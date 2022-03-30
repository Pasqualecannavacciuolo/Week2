package com.exercises.progettoauto;

import java.sql.SQLException;

public class CreateTable extends DBOperations{

    public CreateTable() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.connection = singleton.getConnection();
        this.statement = singleton.createStatement();
    }

    @Override
    void operation() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS `JDBC`.`Auto` (" +
                "  `ID` INT AUTO_INCREMENT," +
                "  `Marchio` VARCHAR(45) NOT NULL," +
                "  `Nazione` VARCHAR(45) NOT NULL," +
                "  `Fatturato` INT NOT NULL," +
                "  `Dipendenti` INT NOT NULL," +
                "  PRIMARY KEY (`ID`));";
        try {
            singleton.getStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            singleton.closeConnection(this.connection, this.statement);
        }
    }

    @Override
    public void run() {
        try {
            operation();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
