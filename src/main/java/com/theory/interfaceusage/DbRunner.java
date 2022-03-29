package com.theory.interfaceusage;

import java.sql.SQLException;

public class DbRunner {
    public static void main(String[] args) throws SQLException {
        DbAccess dbAccess = new DbAccess();
        dbAccess.readDatabase();
    }
}
