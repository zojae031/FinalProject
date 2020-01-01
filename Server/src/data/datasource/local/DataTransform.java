package data.datasource.local;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import data.dao.IngredientModel;

import java.util.ArrayList;

public class DataTransform {
    private String ID;
    private String Password;
    private ArrayList<IngredientModel> ingredient;
    private DataBaseImpl DB;

    public DataTransform(String ID, String Password) {
        this.ID = ID;
        this.Password = Password;
        ingredient = new ArrayList<IngredientModel>();
        DB = DataBaseImpl.getInstance(ID, Password);
    }

    public JsonArray returnIngredient(JsonObject product) {
        String str = product.get("PrIngredient").getAsString();
        JsonArray result = new JsonArray();
        int IgCode;
        String ig[] = str.split("/");
        for(String elem : ig){
            String s[] = elem.split("-");
            JsonObject obj = new JsonObject();
            obj.addProperty("IgCode",Integer.parseInt(s[0]));
            obj.addProperty("IgNumber",Integer.parseInt(s[1]));
            result.add(obj);
        }
        return result;
    }

    public JsonObject returnProductObject(int PrCode) {
        JsonArray arr = DB.getProductArray();
        for (JsonElement obj : arr) {
            if (obj.getAsJsonObject().get("PrCode").getAsInt() == PrCode) {
                return obj.getAsJsonObject();
            }
        }
        return null;
    }

    // TODO: 2020-01-01 Transit Data what you want
    public boolean buyProduct(int PrCode) {
        JsonArray needArr = returnIngredient(returnProductObject(PrCode));
        if (needArr.isJsonNull()) return false;

        JsonArray ingredientArr = DB.getIngredientArray();
        JsonArray toUpdate = new JsonArray();
        for (JsonElement elem : ingredientArr) {
            for (JsonElement need : needArr) {
                if (elem.getAsJsonObject().get("IgCode").getAsInt() == need.getAsJsonObject().get("IgCode").getAsInt()) {
                    if(elem.getAsJsonObject().get("IgNumber").getAsInt() > need.getAsJsonObject().get("IgNumber").getAsInt()){
                        toUpdate.add(need);
                    }
                    else{
                        System.out.println("재료가 부족한 게 있습니다.");
                        return false;
                    }
                }
            }
        }
        DB.updateIngredient(toUpdate);
        return true;
    }
}
