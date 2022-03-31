package com.exercises.progettoauto;

import com.utility.LOG;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert extends DBOperations {
    Scanner input = new Scanner(System.in);
    LOG L = LOG.getInstance();
    PreparedStatement ps = null;
    String _nome, _nazione;
    int _fatturato, _dipendenti;

    public Insert() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
    }

    @Override
    void operation() throws SQLException {
        String sql = "INSERT INTO `JDBC`.`Auto`(`Marchio`, `Nazione`, `Fatturato`, `Dipendenti`) VALUES (?,?,?,?);";
        int nInsert;
        try {
            System.out.print("Quanti inserimenti vuoi effettuare?: ");
            nInsert = input.nextInt();
            for(int i=0; i<nInsert; i++) {
                System.out.print("\nInserisci nome marchio: ");
                _nome = input.next();
                System.out.print("\nInserisci nazione: ");
                _nazione = input.next();
                System.out.print("\nInserisci fatturato: ");
                _fatturato = input.nextInt();
                System.out.print("\nInserisci numero dipendenti: ");
                _dipendenti = input.nextInt();

                ps = singleton.getConnection().prepareStatement(sql);
                ps.setString(1, _nome);
                ps.setString(2, _nazione);
                ps.setInt(3, _fatturato);
                ps.setInt(4, _dipendenti);

                if (ps.executeUpdate() != 0) {
                    L.info("Aggiunto ");
                    ps.clearParameters();
                } else L.info("non aggiunto");
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
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
