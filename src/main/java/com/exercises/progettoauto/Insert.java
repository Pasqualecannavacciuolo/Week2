package com.exercises.progettoauto;

import java.sql.SQLException;
import java.util.Scanner;

public class Insert extends DBOperations{
    Scanner input = new Scanner(System.in);
    String _nome, _nazione;
    int _fatturato, _dipendenti, _id;

    public Insert() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
    }

    @Override
    void operation() throws SQLException {
        String sql = "INSERT INTO `JDBC`.`Auto` (`ID`,`Marchio`, `Nazione`, `Fatturato`, `Dipendenti`) VALUES (default , ?, ?, ?, ?);";
        Auto a = new Auto();
        System.out.print("\nInserisci nome marchio: ");
        _nome = input.next();
        System.out.print("\nInserisci nazione: ");
        _nazione = input.next();
        System.out.print("\nInserisci fatturato: ");
        _fatturato = input.nextInt();
        System.out.print("\nInserisci numero dipendenti: ");
        _dipendenti = input.nextInt();

        try {
            this.preparedStatement = singleton.getPreparedStatement(sql);
            this.preparedStatement.setString(1, a.getNome());
            this.preparedStatement.setString(2, a.getNazione());
            this.preparedStatement.setInt(3, a.getFatturato());
            this.preparedStatement.setInt(4, a.getDipendenti());
            this.preparedStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            singleton.closeConnection(this.connection, this.statement);
        }
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
