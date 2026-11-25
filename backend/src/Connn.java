package com.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connn {
    public static Connection open() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:oracle:thin:@//localhost:1521/xepdb1",
            "inventory_user5", System.getenv("INVENTORY_DB_PASSWORD"));
    }

    public static void main(String[] args) throws SQLException {
        try (Connection db = open()) {
            System.out.println("Connected to " + db.getMetaData().getDatabaseProductName());
        }
    }
}
