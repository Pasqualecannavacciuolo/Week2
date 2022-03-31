package com.exercises.dbemployes;

import com.exercises.progettoauto.Singleton;

import java.sql.*;

public abstract class DBOperations implements Runnable{
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    com.exercises.progettoauto.Singleton singleton = Singleton.getInstance();
    ResultSet resultSet = null;
    abstract void operation() throws SQLException;
}
