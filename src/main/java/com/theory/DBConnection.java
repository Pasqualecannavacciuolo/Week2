package com.theory;

import java.sql.*;

public class DBConnection {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            Class.forName(DBConstant.DB_MYSQL_URL).newInstance();

            connection = DriverManager.getConnection(DBConstant.DB_URL,DBConstant.DB_USER,DBConstant.DB_PASS);

            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM Studente");

            // Ottengo la dimensione del result set (come ottenere la dimensione di un'array)
            ResultSetMetaData md = resultSet.getMetaData();

            while (resultSet.next()) {
                for(int i=1; i<= md.getColumnCount(); i++) {
                    System.out.println(resultSet.getString(i));
                }
                System.out.println("");
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.getMessage();
        } finally {
            close(resultSet, statement, connection);
        }
    }

    private static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {

        if(resultSet != null)
            resultSet.close();

        if(statement != null)
            statement.close();

        if(connection != null)
            connection.close();

    }
}
