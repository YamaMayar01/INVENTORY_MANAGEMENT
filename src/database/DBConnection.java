
package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            String url = "jdbc:oracle:thin:@localhost:1521/ORCL";
            String username = "user1";
            String password = "pass1";

            Connection con = DriverManager.getConnection(
                url, username, password
            );

            return con;

        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }
}
