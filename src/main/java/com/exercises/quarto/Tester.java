package com.exercises.quarto;

import com.exercises.terzo.Singleton;
import com.utility.LOG;
import com.utility.ReadProperties;

import java.io.IOException;
import java.sql.*;

public class Tester {

    public static void main(String[] args) throws SQLException {
        LOG L = LOG.getInstance();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ReadProperties readProperties = new ReadProperties();
        Singleton singleton = Singleton.getInstance();

        try {
            connection = singleton.getConnection();
            readProperties.read("queries.properties");

            // CREATE OPERATION
            String createTable = readProperties.properties.getProperty("db.create");
            //L.info(createTable);
            statement = connection.createStatement();
            //statement.executeUpdate(createTable);

            // INSERT OPERATION
            String insertTable = readProperties.properties.getProperty("db.insert");
            //statement.executeUpdate(insertTable);

            //UPDATE OPERATION
            String updateTable = readProperties.properties.getProperty("db.update");
            String modelToUpdate = "GE007";
            String finalUpdate = updateTable+" WHERE(`modello` = "+"'"+modelToUpdate+"');";
            preparedStatement = connection.prepareStatement(finalUpdate);
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            singleton.closeConnection(resultSet,statement,connection,preparedStatement);
        }
    }
}
