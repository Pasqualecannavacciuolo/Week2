package com.exercises.secondo;

import com.exercises.primo.DB;
import com.theory.DBConstant;

import java.sql.*;

public class DBOperations {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        DBQueries dbQueries = new DBQueries();

        try {

            Class.forName(com.theory.DBConstant.DB_MYSQL_URL).newInstance();

            connection = DriverManager.getConnection(com.theory.DBConstant.DB_URL, com.theory.DBConstant.DB_USER, DBConstant.DB_PASS);

            statement = connection.createStatement();

            // Check if a table already exist
            DatabaseMetaData dbm = connection.getMetaData();
            resultSet = dbm.getTables(null, null, "fornitori", null);
            if (resultSet.next()) { // If table FORNITORI exists
                System.out.println("Table FORNITORI already exists");
            } else { // If not then crete table FORNITORI
                System.out.println("Table does not exist");
                // Create the table 'fornitori'
                statement.executeUpdate(dbQueries.createTable());
            }

            // Adding data to table 'fornitori'
            preparedStatement = connection.prepareStatement(dbQueries.insert());

            // Check on INSERT
            int j = preparedStatement.executeUpdate();
            if(j!=0){
                System.out.println("added"); // If we added data with success
            }
            else{
                System.out.println("failed");
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        } finally {
            close(resultSet, statement, connection, preparedStatement);
        }
    }


    // Method for closing connection
    private static void close(ResultSet resultSet, Statement statement, Connection connection, PreparedStatement preparedStatement) throws SQLException {

        if(resultSet != null)
            resultSet.close();

        if(statement != null)
            statement.close();

        if(preparedStatement != null)
            preparedStatement.close();

        if(connection != null)
            connection.close();

    }


}
