package com.exercises.quinto;

import com.theory.DBConstant;

import java.sql.*;

public class Singleton {
    public static Singleton instance = null;
    public Connection connection = null;
    public PreparedStatement preparedStatement = null;
    public Statement statement = null;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance==null){
            instance = new Singleton();
        }
        return new Singleton();
    }

    // CONNECTION
    public Connection getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class.forName(DBConstant.DB_MYSQL_URL).newInstance();
        connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_PASS);
        return connection;
    }
    public void closeConnection(ResultSet resultSet, Statement statement, Connection connection, PreparedStatement preparedStatement) throws SQLException {

        if(resultSet != null)
            resultSet.close();

        if(statement != null)
            statement.close();

        if(preparedStatement != null)
            preparedStatement.close();

        if(connection != null)
            connection.close();

    }
    public void closeConnection(Connection connection, Statement statement) throws SQLException {
        if(connection != null)
            connection.close();
        if(statement != null)
            statement.close();
    }
    public void closeConnection(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        if(connection != null)
            connection.close();
        if(preparedStatement != null)
            preparedStatement.close();
    }

    // PREPARED STATEMENT
    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query);
        return preparedStatement;
    }

    // STATEMENT
    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }
    public Statement getStatement(String query) throws SQLException {
        statement.executeUpdate(query);
        return statement;
    }

}
