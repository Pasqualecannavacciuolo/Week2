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


    private void selectEmployes() throws SQLException {
        System.out.println("STAMPA EMPLOYES");
        String sql = "SELECT * FROM JDBC.Employes;";
        this.resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String ID = resultSet.getString("ID");
            String Name = resultSet.getString("Name");
            String LastName = resultSet.getString("LastName");
            System.out.println(ID + "\t\t" + Name + "\t\t" + LastName);
        }
    }


    @Override
    void operation() throws SQLException {
        selectEmployes();
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

