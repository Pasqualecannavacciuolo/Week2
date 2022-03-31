package com.exercises.dbemployes;

import java.sql.SQLException;

public class Tester {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Create create = new Create();
        // Creating the table
        create.creation();
        // Inserting data
        Thread thread = new Thread(new Insert());
        thread.start();
    }
}
