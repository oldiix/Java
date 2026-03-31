package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        String url = ConfigUtil.get("db.url");
        String user = ConfigUtil.get("db.username");
        String password = ConfigUtil.get("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}