package com.utility;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// This have the behaviour of a SINGLETON
public class Connection {
    private static Connection instance = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private final ReadProperties readProperties = new ReadProperties();

    private Connection() {}

    public static Connection getInstance() {
        if(instance==null){
            instance = new Connection();
        }
        return new Connection();
    }

    // This method let you connect to the database
    public java.sql.Connection getConnection() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        // Reading from a properties file to prevent SQLINJECTION
        this.readProperties.read("marketapplication.properties");

        String _db_mysql_url = readProperties.properties.getProperty("db.mysql.url");
        String _db_url = readProperties.properties.getProperty("db.url");
        String _db_username = readProperties.properties.getProperty("db.username");
        String _db_password = readProperties.properties.getProperty("db.password");

        Class.forName(_db_mysql_url).newInstance();

        return DriverManager.getConnection(_db_url, _db_username, _db_password);
    }

    // This method link the statement to the connection
    public Statement initStatement() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        statement = getConnection().createStatement();
        return statement;
    }

    /*
     * This method execute a query
     * Better suited for SELECT operations
     */
    public void executeStatementSelect(String query) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        statement.execute(query);
        statement.close();
        getConnection().close();
    }

    /*
     * This method execute a query
     * Better suited for INSERT - UPDATE - DELETE operations
     */
    public Statement executeStatementUpdate(String query) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        statement.executeUpdate(query);
        statement.close();
        getConnection().close();
        return statement;
    }

    // This method prepare a PREPARED STATEMENT
    public PreparedStatement preparePreparedStatement(String query) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        preparedStatement = this.getConnection().prepareStatement(query);
        return preparedStatement;
    }

    // This method execute a PREPARED STATEMENT
    public void executePreparedStatement() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        preparedStatement.executeUpdate();
        preparedStatement.close();
        getConnection().close();
    }
    


}
