package com.exercises.dbemployes;

import java.io.IOException;
import java.sql.SQLException;

public class Tester {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException, NoSuchMethodException, IOException {
        Create create = new Create();
        // Creating the table
        create.creation();

        // Inserting data
        Thread thread = new Thread(new Insert());
        thread.start();
        thread.join();

        // Printing all employes
        thread = new Thread(new Select());
        thread.start();
        thread.join();

        // Deleting a row
        Delete delete = new Delete();
        delete.delete();
    }
}
