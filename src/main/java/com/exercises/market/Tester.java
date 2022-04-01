package com.exercises.market;

import java.io.IOException;
import java.sql.SQLException;

public class Tester {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        DBOperations dbOperations = new DBOperations();
        dbOperations.create();
        dbOperations.insert();
    }
}
