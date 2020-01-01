package client.util

import client.data.dao.ProductModel
import com.google.gson.JsonElement

object JsonUtil {
    fun getProductModel(obj: JsonElement): ProductModel {
        val PrCode: Int = obj.asJsonObject.get("PrCode").asInt
        val PrName: String = obj.asJsonObject.get("PrName").asString
        val PrPrice: Int = obj.asJsonObject.get("PrPrice").asInt
        val PrNumber: Int = obj.asJsonObject.get("PrNumber").asInt
        val PrIngredient: String = obj.asJsonObject.get("PrIngredient").asString
        val isSell: Boolean = obj.asJsonObject.get("IsSell").asBoolean

        return ProductModel(PrCode, PrName, PrPrice, PrNumber, PrIngredient, isSell)
    }
}