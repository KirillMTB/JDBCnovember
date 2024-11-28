package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/customers", "root", "123");
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://172.17.0.1:5432/fullstack2024", "Kirill", "qwerty1234567");
            System.out.println(connection);
            //Statement statement = connection.createStatement();
            //statement.execute("create table java(id int primary key, name varchar(50));");
        }catch (SQLException e) {
            System.out.println(String.format("Ошибка при подключении: %s%n", e.getLocalizedMessage()));
        }

        }
    }
