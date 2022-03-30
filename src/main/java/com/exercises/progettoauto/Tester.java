package com.exercises.progettoauto;

import java.sql.SQLException;

public class Tester {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Thread thread = new Thread(new CreateTable());
        thread.start();
        thread.setPriority(1);
        thread = new Thread(new Insert());
        thread.start();
        thread.setPriority(2);
    }
}
