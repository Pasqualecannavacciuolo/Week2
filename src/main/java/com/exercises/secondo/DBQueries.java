package com.exercises.secondo;

public class DBQueries {

    // Method to create a table
    public String createTable() {
        String sql = "CREATE TABLE `JDBC`.`fornitori` (" +
                "  `codfornitore` VARCHAR(45) NOT NULL," +
                "  `nome` VARCHAR(20) NOT NULL," +
                " `indirizzo` VARCHAR(30) NULL," +
                " `citta` VARCHAR(20) NULL," +
                "  PRIMARY KEY (`codfornitore`));";
        return sql;
    }

    // Method to insert data in the table
    public String insert() {
        String sql = "INSERT INTO fornitori "
                + "VALUES (001, 'Ladroni', 'Via Ostense', 'Roma'),"
                + "(002, 'Risparmietti', 'Viale Marconi', 'Roma'),"
                + "(010, 'Teloporto', 'Via Roma', 'Milano');";
        return sql;
    }
}
