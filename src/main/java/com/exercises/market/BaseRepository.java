package com.exercises.market;

import java.io.IOException;
import java.sql.SQLException;

public interface BaseRepository extends Runnable{
    void create() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    void insert() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    void update() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    void delete() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    void foundByPK() throws IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    void foundByFK() throws IOException, SQLException;
}
