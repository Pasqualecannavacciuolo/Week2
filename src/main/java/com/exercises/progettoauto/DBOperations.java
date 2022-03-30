package com.exercises.progettoauto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBOperations implements Runnable{
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    Singleton singleton = Singleton.getInstance();
    abstract void operation() throws SQLException;
}
