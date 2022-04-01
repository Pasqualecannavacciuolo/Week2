package com.exercises.athletes.athlete;

import java.io.IOException;
import java.sql.SQLException;

public interface BaseRepository {
    void insert() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    void update() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    void delete() throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
