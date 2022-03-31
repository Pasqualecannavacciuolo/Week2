package com.exercises.progettoauto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select extends DBOperations{
    Statement statement = null;
    PreparedStatement ps = null;
    Scanner input = new Scanner(System.in);

    public Select() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
        this.statement = singleton.createStatement();
    }

    private void selectMarchioFatturato() throws SQLException {
        System.out.println("STAMPA MARCHIO-FATTURATO IN ORDINE DISCENDENTE");
        String sql = "SELECT Marchio, Fatturato FROM JDBC.Auto DISC;";
        this.resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String marchio = resultSet.getString("Marchio");
            String fatturato = resultSet.getString("Fatturato");

            System.out.println(marchio + "\t\t" + fatturato);
        }
    }

    private void selectNamesByCountry() throws SQLException{
        System.out.println("STAMPA MARCHIO IN BASE ALLA NAZIONE INSERITA");
        String naz;
        System.out.print("Inserire la nazionalità da ricercare:");
        naz = input.next();
        String sql = "SELECT DISTINCT Marchio, Nazione FROM JDBC.Auto WHERE Nazione="+"'"+naz+"';";
        this.resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String marchio = resultSet.getString("Marchio");

            System.out.println(marchio);
        }
    }

    private void selectDipendentiPerMarchio() throws SQLException {
        System.out.println("STAMPA NUMERO DIPENDENTI PER NAZIONE");
        String naz;
        System.out.print("Inserire la nazionalità da ricercare:");
        naz = input.next();
        String sql = "SELECT COUNT(Dipendenti) AS NumeroDipendenti, Nazione FROM JDBC.Auto WHERE Nazione="+"'"+naz+"';";
        this.resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String nazione = resultSet.getString("Nazione");
            String nDipendenti = resultSet.getString("NumeroDipendenti");
            System.out.println(nazione + "\t\t" + nDipendenti);
        }
    }

    @Override
    void operation() throws SQLException {
        selectMarchioFatturato();
        selectNamesByCountry();
        selectDipendentiPerMarchio();
    }

    @Override
    public void run() {
        try {
            operation();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
