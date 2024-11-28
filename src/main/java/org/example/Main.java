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
            //System.out.println(connection);
            Statement statement = connection.createStatement();
            //statement.execute("create table java(id int primary key, name varchar(50));");
            //statement.execute("CREATE TABLE Products  (Id SERIAL PRIMARY KEY, ProductName VARCHAR(30) NOT NULL, Company VARCHAR(20) NOT NULL, Price NUMERIC NOT NULL);");
            //statement.execute("INSERT INTO Products values (1, 'iPhone X', 'Apple', 66000), (2, 'iPhone 7', 'Apple', 42000), (3, 'Galaxy S9', 'Samsung', 56000), (4, 'Galaxy S8 Plus', 'Samsung', 46000), (5, 'Nokia 9', 'HDM Global', 26000);");
            //statement.execute("CREATE TABLE Customers (Id SERIAL PRIMARY KEY, FirstName VARCHAR(30) NOT NULL);");
            //statement.execute("CREATE TABLE Orders (Id SERIAL PRIMARY KEY, ProductId INTEGER NOT NULL REFERENCES Products(Id) ON DELETE CASCADE, CustomerId INTEGER NOT NULL REFERENCES Customers(Id) ON DELETE CASCADE, CreatedAt DATE NOT NULL, ProductCount INTEGER DEFAULT 1, Price NUMERIC NOT NULL);");
            //statement.execute("INSERT INTO Customers values (1, 'Nick'), (2, 'Tom'), (3, 'Kirill');");
            statement.execute(" INSERT INTO Orders VALUES (1, (SELECT Id FROM Products WHERE ProductName='Galaxy S9'), (SELECT Id FROM Customers WHERE FirstName='Nick'), '2024-07-11', 2, (SELECT Price FROM Products WHERE ProductName='Galaxy S9');");
            connection.close();
        }catch (SQLException e) {
            System.out.println(String.format("Ошибка при подключении: %s%n", e.getLocalizedMessage()));
        }

    }
}