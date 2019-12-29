package data;

public class ProductModel {
    public int PrCode;
    public String PrName;
    public int PrPrice;
    public int PrNumber;
    public String PrIngredient;

    public ProductModel(int PrCode, String PrName, int PrPrice, int PrNumber, String PrIngredient) {
        this.PrCode = PrCode;
        this.PrName = PrName;
        this.PrPrice = PrPrice;
        this.PrNumber = PrNumber;
        this.PrIngredient = PrIngredient;
    }
}
