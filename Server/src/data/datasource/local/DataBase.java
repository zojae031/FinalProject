package data.datasource.local;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public interface DataBase {
    void registerProduct(JsonObject data_Product);//registerProduct

    void registerIngredient(JsonObject data_Ingredient);//registerIngredient

    JsonArray getIngredientArray();//getIngredientArray

    JsonArray getProductArray();
}
