package com.theory.interfaceusage;

import java.sql.SQLException;

public interface Db<K> {
    void readDatabase() throws SQLException;
}
