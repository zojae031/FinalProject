package data.datasource;

import java.sql.*;

public class Database {
    private String jdbcUrl;
    private Connection conn;
    private PreparedStatement pstmt;

    public Database(String Url){
        jdbcUrl = Url;
    }
    public Database(){
        // TODO: 2019-12-28 연결할 IP 연결하기
        jdbcUrl = "jdbc://mysql://localhost/javadb";
    }

    public void connectDB(){
        // FIXME: 2019-12-28 ID Password 입력
        try {
            conn = DriverManager.getConnection(jdbcUrl,"eknow25","2486xawd!@");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeDB(){
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
