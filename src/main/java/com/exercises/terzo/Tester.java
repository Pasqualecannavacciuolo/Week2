package com.exercises.terzo;

import com.exercises.secondo.DBQueries;
import com.theory.DBConstant;

import java.sql.*;

public class Tester {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        DBQueries dbQueries = new DBQueries();
        Singleton singleton = Singleton.getInstance();

        try {

            connection = singleton.getConnection();
            // Adding data to table 'fornitori'
            String sql = "CREATE TABLE `JDBC`.`gggtt` (" +
                    "  `codfornitore` VARCHAR(45) NOT NULL," +
                    "  `nome` VARCHAR(20) NOT NULL," +
                    " `indirizzo` VARCHAR(30) NULL," +
                    " `citta` VARCHAR(20) NULL," +
                    "  PRIMARY KEY (`codfornitore`));";
            preparedStatement = singleton.getPreparedStatement(sql);
            preparedStatement = connection.prepareStatement(sql);

            // Check on INSERT
            int j = preparedStatement.executeUpdate();
            if (j == 0) {
                System.out.println("Created"); // If we added data with success
            } else {
                System.out.println("failed");
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        } finally {
            singleton.closeConnection(resultSet, statement, connection, preparedStatement);
        }
    }
}
