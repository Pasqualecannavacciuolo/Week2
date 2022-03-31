package com.exercises.progettoauto;

import java.sql.*;

public abstract class DBOperations implements Runnable{
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    Singleton singleton = Singleton.getInstance();
    ResultSet resultSet = null;
    abstract void operation() throws SQLException;
}
