package com.exercises.dbemployes;

import com.utility.LOG;
import com.utility.ReadProperties;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    Scanner input = new Scanner(System.in);
    ReadProperties readProperties = new ReadProperties();
    LOG L = LOG.getInstance();
    PreparedStatement ps = null;
    Singleton singleton = Singleton.getInstance();

    // Methods to eliminate a row given an ID
    void delete() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        int valueToDelete;
        System.out.print("Inserire ID da eliminare: ");
        valueToDelete = input.nextInt();

        readProperties.read("employes.properties");
        String sql = readProperties.properties.getProperty("db.delete");
        ps = singleton.getConnection().prepareStatement(sql) ;
        ps.setInt(1, valueToDelete);

        if (ps.executeUpdate() != 0) {
            L.info("Record eliminato ");
            ps.clearParameters();
        } else L.error("ERRORE");
    }
}
