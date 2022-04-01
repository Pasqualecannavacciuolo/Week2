package com.exercises.athletes.athlete;

import com.exercises.athletes.utility.LOG;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner input = new Scanner(System.in);

        DBOperations dbOperations = new DBOperations();
        LOG L = LOG.getInstance();

        // Create the table
        dbOperations.createTable();
        String c = null;
        int s = 0;
        while(s!=5) {
            System.out.println("Cosa vuoi fare?: ");
            System.out.println("|------- |-----|");
            System.out.println("| INSERT |  1  |");
            System.out.println("| SELECT |  2  |");
            System.out.println("| UPDATE |  3  |");
            System.out.println("| DELETE |  4  |");
            System.out.println("|  EXIT  |  5  |");
            System.out.println("|------- |-----|");
            System.out.print("\nScelta: ");
            s = input.nextInt();
            switch (s) {
                case 1: {
                    dbOperations.insert();
                    break;
                }
                case 2: {
                    dbOperations.select();
                    break;
                }
                case 3: {
                    dbOperations.update();
                    break;
                }
                case 4: {
                    dbOperations.delete();
                    break;
                }
                case 5: {
                    System.exit(0);
                }
            }
        }
    }
}
