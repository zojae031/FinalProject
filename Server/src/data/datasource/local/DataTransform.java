package data.datasource.local;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class DataTransform{
    private String ID;
    private String Password;
    public DataTransform(String ID,String Password){
        this.ID = ID;
        this.Password = Password;
    }

    public JsonArray returnIngredient(JsonObject product){
        String str = product.get("PrIngredient").toString();
        JsonArray result = new JsonArray();
        String PrCode = null;
        while(!str.equals("")){
            PrCode = str.substring(0,4);
            str = str.substring(4);
            int number = Integer.parseInt(str.substring(0,str.indexOf("/")));
            str = str.substring(str.indexOf("/"));
            JsonObject obj = new JsonObject();
            obj.addProperty(PrCode,number);
            result.add(obj);
        }
        return result;
    }

    // TODO: 2020-01-01 Transit Data what you want

}
