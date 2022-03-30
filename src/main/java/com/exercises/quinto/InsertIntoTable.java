package com.exercises.quinto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoTable implements Runnable{

    PreparedStatement preparedStatement = null;
    Connection connection = null;
    Singleton singleton = Singleton.getInstance();

    public InsertIntoTable() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
    }

    @Override
    public void run() {
        String sql = "INSERT INTO `Dipartimento`.`Anagrafica` (`Nome`, `Cognome`, `Eta`, `Citta`, `Provincia`, `CAP`) VALUES ('Pasquale', 'Cannavacciuolo', '24', 'Napoli', 'NA', '81100');";
        try { // PREPARO LO STATEMENT CON LA QUERY ASSEGNATA
            preparedStatement = singleton.getPreparedStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try { // Eseguo l'INSERT
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { // CHIUDO LA CONNESSIONE
                singleton.closeConnection(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
