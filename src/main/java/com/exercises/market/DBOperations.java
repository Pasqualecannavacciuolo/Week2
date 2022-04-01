package com.exercises.market;

import com.exercises.athletes.utility.Connection;
import com.exercises.athletes.utility.ReadProperties;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBOperations implements BaseRepository{
    Scanner input = new Scanner(System.in);
    ReadProperties rd = new ReadProperties();
    // Singleton utility
    Connection conn = Connection.getInstance();
    Client client;
    Order order;

    // GETTING THE DATA FOR CLIENTS AND ORDERS
    private Client getClientData() {
        System.out.print("\nCodice cliente: ");
        int idClient = input.nextInt();
        System.out.print("\nNome cliente: ");
        String name = input.next();
        System.out.print("\nCognome cliente: ");
        String lastname = input.next();
        System.out.print("\nEtà cliente: ");
        int age = input.nextInt();
        return this.client = Client.builder()
                .idClient(idClient)
                .name(name)
                .lastname(lastname)
                .age(age)
                .build();
    }
    private Order getOrderData() {
        System.out.print("\nCodice ordine: ");
        int idOrder = input.nextInt();
        System.out.print("\nCodice cliente: ");
        int idClient = input.nextInt();
        return this.order = Order.builder()
                .idOrder(idOrder)
                .idClient(idClient)
                .build();
    }

    // CREATE THE TABLES IF NOT EXISTS
    @Override
    public void create() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        rd.read("marketqueries.properties");
        String sql = rd.properties.getProperty("db.create.clients");
        conn.initStatement();
        conn.executeStatementSelect(sql);
        String sql2 = rd.properties.getProperty("db.create.orders");
        conn.initStatement();
        conn.executeStatementSelect(sql2);
    }

    // INSERT DATA INTO THE TABLES
    @Override
    public void insert() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.print("Numero ordini: ");
        int nInsert = input.nextInt();
        for(int i=0; i<nInsert; i++) {

            // Insert for CLIENT
            PreparedStatement psClient;
            String sqlClient = rd.properties.getProperty("db.insert.client");
            Client c = getClientData();
            psClient = conn.preparePreparedStatement(sqlClient);
            psClient.setInt(1, c.getIdClient());
            psClient.setString(2, c.getName());
            psClient.setString(3, c.getLastname());
            psClient.setInt(4, c.getAge());
            conn.executePreparedStatement();

            // INSERT FOR ORDER
            PreparedStatement psOrder;
            String sqlOrder = rd.properties.getProperty("db.insert.order");
            Order o = getOrderData();
            psOrder = conn.preparePreparedStatement(sqlOrder);
            psOrder.setInt(1, o.getIdOrder());
            psOrder.setInt(2, c.getIdClient()); // get client id from before
            conn.executePreparedStatement();
        }
    }

    // UPDATE DATA IN TABLES
    @Override
    public void update() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        rd.read("marketqueries.properties");

        PreparedStatement psClient;
        String sqlClient = rd.properties.getProperty("db.update.client");
        System.out.print("\n Nuovo nome: ");
        String name = input.next();
        System.out.print("\n idClient a cui cambiare nome: ");
        int idClient = input.nextInt();
        psClient = conn.preparePreparedStatement(sqlClient);
        psClient.setString(1, name);
        psClient.setInt(2, idClient);
        conn.executePreparedStatement();

        PreparedStatement psOrder;
        String sqlOrder = rd.properties.getProperty("db.update.order");
        System.out.print("\n idOrder da cambiare: ");
        int idOrder = input.nextInt();
        System.out.print("\n idOrder nuovo: ");
        int idOrderNew = input.nextInt();
        psOrder = conn.preparePreparedStatement(sqlOrder);
        psOrder.setInt(1, idOrderNew);
        psOrder.setInt(2, idOrder);
        conn.executePreparedStatement();

    }

    @Override
    public void delete() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    }

    @Override
    public void run() {

    }
}
