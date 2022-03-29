package com.theory;

import java.sql.*;

public class DBConnection {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String DB_USER = "root";
        String DB_PASS = "Toor123@";
        String DB_URL = "jdbc:mysql://localhost/JDBC?";
        String DB_MYSQL_URL = "com.mysql.cj.jdbc.Driver";
        try {

            Class.forName(DBConstant.DB_MYSQL_URL).newInstance();

            connection = DriverManager.getConnection(DBConstant.DB_URL,DBConstant.DB_USER,DBConstant.DB_PASS);

            String sql = "CREATE TABLE `JDBC`.`persona` (" +
                    "  `idpersona` INT NOT NULL," +
                    "  `name` VARCHAR(45) NULL," +
                    " `lastname` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`idpersona`));";


            statement = connection.createStatement();
            statement.executeUpdate(sql);
            //resultSet = statement.executeQuery(sql);

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
