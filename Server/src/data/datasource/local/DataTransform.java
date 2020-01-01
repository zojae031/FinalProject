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
        String str = product.get("PrIngredient").toString();
        JsonArray result = new JsonArray();
        String PrCode = null;
        while (!str.equals("")) {
            PrCode = str.substring(0, 4);
            str = str.substring(4);
            int number = Integer.parseInt(str.substring(0, str.indexOf("/")));
            str = str.substring(str.indexOf("/"));
            JsonObject obj = new JsonObject();
            obj.addProperty(PrCode, number);
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
    boolean buyProduct(int PrCode) {
        JsonArray needArr = returnIngredient(returnProductObject(PrCode));
        if (needArr.isJsonNull()) return false;
        JsonArray ingredientArr = DB.getIngredientArray();

        for (JsonElement elem : ingredientArr) {
            for (JsonElement need : needArr) {
                if (elem.getAsJsonObject().get("PrCode") == need.getAsJsonObject().get("PrCode")) {

                }
            }
        }


        return true;
    }
}
