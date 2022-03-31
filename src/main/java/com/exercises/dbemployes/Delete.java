package com.exercises.dbemployes;

import com.utility.LOG;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    Scanner input = new Scanner(System.in);
    LOG L = LOG.getInstance();
    PreparedStatement ps = null;
    Singleton singleton = Singleton.getInstance();
    void delete() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        int valueToDelete;
        System.out.print("Inserire ID da eliminare: ");
        valueToDelete = input.nextInt();
        String sql = "DELETE FROM `JDBC`.`Employes` WHERE ID="+"'"+valueToDelete+"';";
        ps = singleton.getConnection().prepareStatement(sql);
        if (ps.executeUpdate() != 0) {
            L.info("Record eliminato ");
            ps.clearParameters();
        } else L.error("ERRORE");
    }
}
