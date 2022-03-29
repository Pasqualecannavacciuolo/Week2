package com.theory.interfaceusage;

import com.theory.DBConstant;
import com.utility.LOG;

import java.sql.*;

public class DbAccess implements Db<ResultSet>{

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    public static final String DB_USER = "root";
    public static final String DB_PASS = "Toor123@";
    public static final String DB_URL = "jdbc:mysql://localhost/JDBC?";
    public static final String DB_MYSQL_URL = "com.mysql.cj.jdbc.Driver";

    @Override
    public void readDatabase() throws SQLException{
        try {
            LOG L = LOG.getInstance();
            Class.forName(DBConstant.DB_MYSQL_URL).newInstance();

            connection = DriverManager.getConnection(DBConstant.DB_URL,DBConstant.DB_USER,DBConstant.DB_PASS);

            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM fornitori");

            // Ottengo la dimensione del result set (come ottenere la dimensione di un'array)
            ResultSetMetaData md = resultSet.getMetaData();

            while (resultSet.next()) {
                for(int i=1; i<= md.getColumnCount(); i++) {
                    L.info(resultSet.getString(i));
                    //System.out.println(resultSet.getString(i));
                }
                System.out.println("");
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.getMessage();
        } finally {
            close(resultSet, statement, connection, preparedStatement);
        }
    }
    private static void close(ResultSet resultSet, Statement statement, Connection connection, PreparedStatement preparedStatement) throws SQLException {

        if(resultSet != null)
            resultSet.close();

        if(statement != null)
            statement.close();

        if(connection != null)
            connection.close();

        if(preparedStatement != null)
            preparedStatement.close();

    }

}
