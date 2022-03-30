package com.exercises.quinto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Create implements Runnable{
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    Singleton singleton = Singleton.getInstance();
    abstract void creation() throws SQLException;
}
