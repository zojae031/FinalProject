package data.datasource.local;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.sql.*;

public class DataBaseImpl implements DataBase {
    private String jdbcUrl;
    private Connection conn;
    private PreparedStatement pstmt;
    private String ID, Password;

    public DataBaseImpl(String Url) {
        jdbcUrl = Url;
    }

    public DataBaseImpl(String ID, String Password) {
        // TODO: 2019-12-28 연결할 IP 연결하기
        jdbcUrl = "jdbc://mysql://localhost/javadb";
        this.ID = ID;
        this.Password = Password;
    }

    private void connectDB() {
        try {
            conn = DriverManager.getConnection(jdbcUrl, ID, Password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeDB() {
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerProduct(JsonObject data_Product) {
        connectDB();
        String sql = "insert into product values(?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data_Product.get("PrCode").getAsString());
            pstmt.setString(2, data_Product.get("PrName").getAsString());
            pstmt.setString(3, data_Product.get("PrPrice").getAsString());
            pstmt.setString(4, data_Product.get("PrNumber").getAsString());
            pstmt.setString(5, data_Product.get("PrIngredient").getAsString());
            pstmt.execute();
            System.out.println("DB에 [Product]가 저장되었습니다.");
        } catch (SQLException e) {
            System.out.println("DB 저장 실패[Product]");
            e.printStackTrace();
        }
    }//registerProduct

    @Override
    public void registerIngredient(JsonObject data_Ingredient) {
        connectDB();
        String sql = "insert into ingredient values(?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data_Ingredient.get("IgCode").getAsString());
            pstmt.setString(2, data_Ingredient.get("IgName").getAsString());
            pstmt.setString(3, data_Ingredient.get("IgNumber").getAsString());
            pstmt.setString(4, data_Ingredient.get("IgPrice").getAsString());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//registerIngredient

    @Override
    public JsonArray getProductArray() {
        connectDB();
        String sql = "select * from product";
        JsonArray result = new JsonArray();
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            JsonObject input;
            while (rs.next()) {
                input = new JsonObject();
                input.addProperty("PrCode", rs.getString("PrCode"));
                input.addProperty("PrName", rs.getString("PrName"));
                input.addProperty("PrPrice", rs.getString("PrPrice"));
                input.addProperty("PrNumber", rs.getString("PrNumber"));
                input.addProperty("PrIngredient", rs.getString("PrIngredient"));
                result.add(input);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeDB();
        return result;
    }//getProductArray

    @Override
    public JsonArray getIngredientArray() {
        connectDB();
        String sql = "select * from ingredient";
        JsonArray result = new JsonArray();
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            JsonObject input;
            while (rs.next()) {
                input = new JsonObject();
                input.addProperty("IgCode", rs.getString("IgCode"));
                input.addProperty("IgName", rs.getString("IgName"));
                input.addProperty("IgNumber", rs.getString("IgNumber"));
                input.addProperty("IgPrice", rs.getString("IgPrice"));
                result.add(input);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeDB();
        return result;
    }//getIngredientArray

}// Class DataBase
