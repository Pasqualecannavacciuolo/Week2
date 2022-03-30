package com.exercises.quinto;

import java.sql.SQLException;

public class CreateTable extends Create implements Runnable{

    public CreateTable() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
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
        String sql = "CREATE TABLE IF NOT EXISTS `Dipartimento`.`Anagrafica` (" +
                "  `ID` INT NOT NULL AUTO_INCREMENT," +
                "  `Nome` VARCHAR(45) NOT NULL," +
                "  `Cognome` VARCHAR(45) NOT NULL," +
                "  `Eta` INT NOT NULL," +
                "  `Citta` VARCHAR(45) NOT NULL," +
                "  `Provincia` VARCHAR(45) NOT NULL," +
                "  `CAP` INT NOT NULL," +
                "  PRIMARY KEY (`ID`)," +
                "  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE);";
        try {
            singleton.getStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            singleton.closeConnection(this.connection, this.statement);
        }
    }
}

