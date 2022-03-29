package com.exercises.terzo;

import com.theory.DBConstant;

import java.sql.*;

public class Singleton {
    public static Singleton instance = null;
    public Connection connection = null;
    public PreparedStatement preparedStatement = null;


    private Singleton(){}

    public static Singleton getInstance() {
        if(instance==null){
            instance = new Singleton();
        }
        return new Singleton();
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class.forName(com.theory.DBConstant.DB_MYSQL_URL).newInstance();
        connection = DriverManager.getConnection(com.theory.DBConstant.DB_URL, com.theory.DBConstant.DB_USER, DBConstant.DB_PASS);
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

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query);
        return preparedStatement;
    }
}
