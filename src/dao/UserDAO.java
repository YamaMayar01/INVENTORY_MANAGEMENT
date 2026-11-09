package dao;

import database.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User findByEmail(String email) {

        String sql = "SELECT USERID, NAME, ROLE, EMAIL, PASSWORDHASH "
                   + "FROM USERS WHERE EMAIL = ?";

        try (Connection con = DBConnection.getConnection()) {

            if (con == null) {
                return null;
            }

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, email);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {
                        return new User(
                            rs.getInt("USERID"),
                            rs.getString("NAME"),
                            rs.getString("ROLE"),
                            rs.getString("EMAIL"),
                            rs.getString("PASSWORDHASH")
                        );
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }
}