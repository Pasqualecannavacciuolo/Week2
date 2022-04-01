package com.exercises.athletes.athlete;


import com.exercises.athletes.utility.Connection;
import com.exercises.athletes.utility.ReadProperties;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBOperations implements BaseRepository{
    List<Athlete> athleths = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    Athlete a;
    Connection conn = Connection.getInstance();
    Statement statement = conn.initStatement();
    ReadProperties rd = new ReadProperties();
    ResultSet rs = null;

    public DBOperations() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    // This method creates a table if not exists in the database
    public void createTable() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        rd.read("athletesqueries.properties");
        String sql = rd.properties.getProperty("db.create");
        conn.initStatement();
        conn.executeStatementSelect(sql);
    }

    // This method prints the athlete with code equals to the one given in input
    public void findByID() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        int cod;
        System.out.print("Inserire Cod da ricercare:");
        cod = input.nextInt();
        System.out.println("STAMPA ATLETA IN BASE AL CODICE RICERCATO");
        ResultSet resultSet;

        String sql = "SELECT Name, Nationality FROM Olympics.Athletes WHERE Cod="+cod;
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String name = resultSet.getString("Name");
            String nationality = resultSet.getString("Nationality");
            System.out.println(name + "\t\t" + nationality);
        }
        resultSet.close();
    }

    // This method prints all the athletes
    public void findALL() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("STAMPA TUTTI GLI ATLETI");
        Athlete aTmp;
        ResultSet resultSet;

        String sql = "SELECT * FROM Olympics.Athletes";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int cod = resultSet.getInt("Cod");
            String name = resultSet.getString("Name");
            String nationality = resultSet.getString("Nationality");
            String birth = resultSet.getString("BirthDate");
            int height = resultSet.getInt("Height");

            System.out.println(cod + "\t\t" + name + "\t\t" + nationality + "\t\t" + birth + "\t\t" + height);
            aTmp = Athlete.builder()
                    .cod(cod)
                    .name(name)
                    .nationality(nationality)
                    .birthDate(birth)
                    .height(height)
                    .build();
            // Adding the athlete to the athletes list
            athleths.add(aTmp);
        }
        statement.close();
        resultSet.close();
    }

    // This method find the highest athlete in a list of athletes
    public void findHighest(int h) {
        for(Athlete a: athleths){
            if(a.getHeight()>h) {
                System.out.println(a.getName() + "\t\t" + a.getHeight());
            }
        }
    }

    // This method group all the SELECT OPERATIONS
    public void select() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        findByID();
        findALL();
        System.out.println("Finding the highest athletes");
        System.out.print("Altezza da confrontare: ");
        int p = input.nextInt();
        findHighest(p);
    }

    // Method to get the athlete data
    private Athlete setAthleteData() {
        int cod,height;
        String name, nationality;
        String birthdate;

        System.out.print("\nCodice atleta: ");
        cod = input.nextInt();
        System.out.print("\nNome atleta: ");
        name = input.next();
        System.out.print("\nNazionalità atleta: ");
        nationality = input.next();
        System.out.print("\nData di nascita atleta: ");
        birthdate = input.next();
        System.out.print("\nAltezza atleta: ");
        height = input.nextInt();
        Athlete a =  Athlete.builder()
                .cod(cod)
                .name(name)
                .nationality(nationality)
                .birthDate(birthdate)
                .height(height)
                .build();
        return a;
    }

    private void addingToList() {
        Athlete athlete;

    }


    // This method insert data in the table
    @Override
    public void insert() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.print("Numero inserimenti: ");
        int nInsert = input.nextInt();
        for(int i=0; i<nInsert; i++) {
            Athlete a = setAthleteData();

            PreparedStatement ps;

            String sql = rd.properties.getProperty("db.insert");

            ps = conn.preparePreparedStatement(sql);
            ps.setInt(1, a.getCod());
            ps.setString(2, a.getName());
            ps.setString(3, a.getNationality());
            ps.setDate(4, java.sql.Date.valueOf(a.getBirthDate()));
            ps.setInt(5, a.getHeight());
            conn.executePreparedStatement();
        }
    }

    @Override
    public void update() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = rd.properties.getProperty("db.update");
        PreparedStatement ps;

        System.out.print("\nNuova altezza: ");
        int height = input.nextInt();
        System.out.print("\nCodice atleta a cui modificare l'altezza: ");
        int cod = input.nextInt();

        ps = conn.preparePreparedStatement(sql);
        ps.setInt(1, height);
        ps.setInt(2, cod);

        conn.executePreparedStatement();

    }

    @Override
    public void delete() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String sql = rd.properties.getProperty("db.delete");
        PreparedStatement ps;

        System.out.print("\nCodice atleta da eliminare: ");
        int cod = input.nextInt();

        ps = conn.preparePreparedStatement(sql);
        ps.setInt(1, cod);

        conn.executePreparedStatement();
    }
}
