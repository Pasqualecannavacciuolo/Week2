package com.exercises.dbemployes;

import com.utility.ReadProperties;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select extends DBOperations {
    Statement statement = null;
    PreparedStatement ps = null;
    ReadProperties readProperties = new ReadProperties();
    Scanner input = new Scanner(System.in);

    public Select() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
        this.statement = singleton.createStatement();
    }

    @SingleValue(value = "selectEmployes")
    private void selectEmployes() throws SQLException, IOException {

        System.out.println("STAMPA EMPLOYES");
        readProperties.read("employes.properties");
        String sql = readProperties.properties.getProperty("db.select");
        this.resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String ID = resultSet.getString("ID");
            String Name = resultSet.getString("Name");
            String LastName = resultSet.getString("LastName");
            System.out.println(ID + "\t\t" + Name + "\t\t" + LastName);
        }
    }


    @Override
    void operation() throws SQLException, IOException {
        selectEmployes();
    }

    @Override
    public void run() {
        try {
            operation();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

