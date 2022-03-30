package com.exercises.quinto;

import java.sql.*;

public class Tester implements Runnable{
    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        Singleton singleton = Singleton.getInstance();

        try {
            Class.forName(com.theory.DBConstant.DB_MYSQL_URL).newInstance();

            connection = singleton.getConnection();
            statement = connection.createStatement();

            Thread TSchema = new Thread(new CreateSchema());
            Thread TTable = new Thread(new CreateTable());
            Thread TInsert = new Thread(new InsertIntoTable());

            // Create SCHEMA
            TSchema.start();
            TSchema.setPriority(1);

            // Create TABLE
            TTable.start();
            TTable.setPriority(2);

            // INSERT into TABLE
            TInsert.start();
            TInsert.setPriority(3);

            // PRINT TABLE ROWS
            String sql = "SELECT * FROM Dipartimento.Anagrafica;";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String Nome = resultSet.getString("Nome");
                String Cognome = resultSet.getString("Cognome");
                int Eta = resultSet.getInt("Eta");
                String Citta = resultSet.getString("Citta");
                String Provincia = resultSet.getString("Provincia");
                int CAP = resultSet.getInt("CAP");
                System.out.println(id + "\t\t" + Nome + "\t\t" + Cognome + "\t\t" + Eta + "\t\t" + Citta + "\t\t" + Provincia + "\t\t" + CAP);
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        } finally {
            singleton.closeConnection(resultSet, statement, connection, singleton.getPreparedStatement(String.valueOf(new InsertIntoTable().preparedStatement)));
        }
    }

    @Override
    public void run() {

    }
}
