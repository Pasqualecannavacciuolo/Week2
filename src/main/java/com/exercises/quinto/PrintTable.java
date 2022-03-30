package com.exercises.quinto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintTable implements Runnable{
    Connection connection = null;
    Statement statement = null;
    Singleton singleton = Singleton.getInstance();
    
    public PrintTable() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
        this.statement = singleton.createStatement();
    }
    
    @Override
    public void run() {
        String sql = "SELECT * FROM Dipartimento.Anagrafica;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                singleton.closeConnection(this.connection, this.statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
