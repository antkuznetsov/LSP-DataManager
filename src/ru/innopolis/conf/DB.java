package ru.innopolis.conf;

import java.sql.*;

/**
 * Created by Kuznetsov on 13/04/2017.
 */

public class DB {

    private String dbName = "lsp-1";
    private String dbLogin = "postgres";
    private String dbPassword = "786952na";

    public Connection initConnection() {

        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Проблема с драйвером");
            e.printStackTrace();

        }

        try {

            connection = DriverManager.getConnection("jdbc:postgresql://localhost/" + dbName, dbLogin, dbPassword);

        } catch (SQLException e) {

            System.out.println("Проблема с соединением");
            e.printStackTrace();

        }
        return connection;

    }

    public void get() {

        Connection connection = initConnection();

        try {

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM users");

            while (result.next()) {

                System.out.print(result.getInt("id") + " ");
                System.out.print(result.getString("name") + " ");
                System.out.print(result.getString("last_name") + " ");
                System.out.print(result.getString("email") + " ");
                System.out.print(result.getString("password") + " ");
                System.out.print(result.getInt("group_id") + " ");
                System.out.print("\n");

            }

        } catch (SQLException e) {

            System.out.println("Проблема с запросом");
            e.printStackTrace();
        }

    }

}
