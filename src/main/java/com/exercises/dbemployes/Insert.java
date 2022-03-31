package com.exercises.dbemployes;

import com.utility.LOG;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert extends DBOperations {
    Scanner input = new Scanner(System.in);
    LOG L = LOG.getInstance();
    PreparedStatement ps = null;
    String _name, _lastname;
    int _id;

    public Insert() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
    }

    @Override
    void operation() throws SQLException {
        String sql = "INSERT INTO `JDBC`.`Employes`(`ID`,`Name`, `LastName`) VALUES (?,?,?);";
        int nInsert;
        try {
            System.out.print("Quanti inserimenti vuoi effettuare?: ");
            nInsert = input.nextInt();
            for(int i=0; i<nInsert; i++) {
                System.out.print("\nInserisci ID: ");
                _id = input.nextInt();
                System.out.print("\nInserisci nome: ");
                _name = input.next();
                System.out.print("\nInserisci cognome: ");
                _lastname = input.next();

                ps = singleton.getConnection().prepareStatement(sql);
                ps.setInt(1, _id);
                ps.setString(2, _name);
                ps.setString(3, _lastname);

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
