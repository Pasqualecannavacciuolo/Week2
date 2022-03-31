package com.exercises.dbemployes;

import com.utility.LOG;
import com.utility.ReadProperties;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert extends DBOperations {
    Scanner input = new Scanner(System.in);
    ReadProperties readProperties = new ReadProperties();
    LOG L = LOG.getInstance();
    PreparedStatement ps = null;
    String _name, _lastname;
    int _id;

    public Insert() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
    }

    private Employe setEmployeData() {
        System.out.print("\nInserisci ID: ");
        _id = input.nextInt();
        System.out.print("\nInserisci nome: ");
        _name = input.next();
        System.out.print("\nInserisci cognome: ");
        _lastname = input.next();
        Employe e = new Employe(_id, _name, _lastname);
        return e;
    }

    @Override
    void operation() throws SQLException {
        int nInsert;
        try {
            readProperties.read("employes.properties");
            String sql = readProperties.properties.getProperty("db.insert");
            System.out.print("Quanti inserimenti vuoi effettuare?: ");
            nInsert = input.nextInt();
            for(int i=0; i<nInsert; i++) {
                Employe tmpE = setEmployeData();
                ps = singleton.getConnection().prepareStatement(sql);
                ps.setInt(1, tmpE.getID());
                ps.setString(2, tmpE.getName());
                ps.setString(3, tmpE.getLastname());

                if (ps.executeUpdate() != 0) {
                    L.info("Aggiunto ");
                    ps.clearParameters();
                } else L.info("non aggiunto");
            }

        } catch (SQLException | IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
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
