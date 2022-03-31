package com.exercises.dbemployes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
    Statement statement = null;
    Connection connection = null;
    Singleton singleton = Singleton.getInstance();

    public Create() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
        this.statement = singleton.createStatement();
    }

    void creation() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS `JDBC`.`Employes` (" +
                "  `ID` INT," +
                "  `Name` VARCHAR(45) NOT NULL," +
                "  `LastName` VARCHAR(45) NOT NULL,"+
                "  PRIMARY KEY (`ID`));";
        try {
            singleton.getStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            singleton.closeConnection(this.connection, this.statement);
        }
    }

}
