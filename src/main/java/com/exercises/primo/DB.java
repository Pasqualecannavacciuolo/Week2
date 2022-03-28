package com.exercises.primo;

import com.theory.DBConstant;

import java.sql.*;


public class DB {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DBConstant.DB_MYSQL_URL).newInstance();

            connection = DriverManager.getConnection(DBConstant.DB_URL,DBConstant.DB_USER,DBConstant.DB_PASS);

            statement = connection.createStatement();
            Person p = new Person();
            p.setId(100);
            p.setName("Person");
            p.setLastname("Test");
            p.setEmail("p.test@test.com");
            p.setEnabled(1);
            p.setAge(50);

            preparedStatement = connection.prepareStatement("INSERT INTO Studente(idStudente, Name, LastName, email, enabled, age) values (?,?,?,?,?,?)");

            preparedStatement.setInt(1, p.getId());
            preparedStatement.setString(2, p.getName());
            preparedStatement.setString(3, p.getLastname());
            preparedStatement.setString(4, p.getEmail());
            preparedStatement.setInt(5, p.getEnabled());
            preparedStatement.setInt(6, p.getAge());

            int j = preparedStatement.executeUpdate();
            if(j!=0){
                System.out.println("added");
            }
            else{
                System.out.println("failed");
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.getMessage();
        } finally {
            close(resultSet, statement, connection);
        }
    }


    // Method for closing connection
    private static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {

        if(resultSet != null)
            resultSet.close();

        /*if(statement != null)
            statement.close();*/

        if(connection != null)
            connection.close();

    }

    public static class Person {
        private int id;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        private String name;
        private String lastname;
        private String email;
        private int enabled;
        private int age;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getLastname() {
            return lastname;
        }
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public int getEnabled() {
            return enabled;
        }
        public void setEnabled(int enabled) {
            this.enabled = enabled;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }
}
