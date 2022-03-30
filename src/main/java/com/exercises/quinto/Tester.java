package com.exercises.quinto;

import java.sql.*;

public class Tester implements Runnable{
    public static void main(String[] args) throws InterruptedException{

        try {

            Thread TSchema = new Thread(new CreateSchema());
            Thread TTable = new Thread(new CreateTable());
            Thread TInsert = new Thread(new InsertIntoTable());
            Thread TPrint = new Thread(new PrintTable());

            // Create SCHEMA
            TSchema.start();
            TSchema.setPriority(1);

            // Create TABLE
            TTable.start();
            TTable.setPriority(2);

            // INSERT into TABLE
            TInsert.start();
            TInsert.setPriority(3);

            // PRINT TABLE ROWS
            TPrint.start();
            TPrint.setPriority(4);


        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {

    }
}
