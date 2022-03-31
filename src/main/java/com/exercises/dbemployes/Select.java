package com.exercises.dbemployes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select extends DBOperations {
    Statement statement = null;
    PreparedStatement ps = null;
    Scanner input = new Scanner(System.in);

    public Select() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
        this.statement = singleton.createStatement();
    }



    @Override
    void operation() throws SQLException {

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

