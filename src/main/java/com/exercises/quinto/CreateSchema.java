package com.exercises.quinto;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateSchema extends Create {

    public CreateSchema() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
        this.statement = singleton.createStatement();
    }


    @Override
    public void run() {
        try {
            creation();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void creation() throws SQLException {
        String sql = "CREATE SCHEMA IF NOT EXISTS `Dipartimento` ;";
        try {
            singleton.getStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            singleton.closeConnection(this.connection, this.statement);
        }
    }
}
