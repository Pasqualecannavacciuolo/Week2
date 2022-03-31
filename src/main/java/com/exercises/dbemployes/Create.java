package com.exercises.dbemployes;

import com.utility.ReadProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
    Statement statement = null;
    Connection connection = null;
    Singleton singleton = Singleton.getInstance();
    ReadProperties readProperties = new ReadProperties();

    public Create() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
        this.statement = singleton.createStatement();
    }
    @SingleValue(value = "creation")
    void creation() throws SQLException {

        try {
            readProperties.read("employes.properties");
            String sql = readProperties.properties.getProperty("db.create");
            singleton.getStatement(sql);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            singleton.closeConnection(this.connection, this.statement);
        }
    }

}
