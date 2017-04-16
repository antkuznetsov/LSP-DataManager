package ru.innopolis.conf;

import java.sql.*;

/**
 * Created by Kuznetsov on 13/04/2017.
 */

public class DB {

    private final String DBNAME = "lsp-1";
    private final String DBLOGIN = "postgres";
    private final String DBPASSWORD = "786952na";

    public Connection initConnection() {

        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Проблема с драйвером");
            e.printStackTrace();

        }

        try {

            connection = DriverManager.getConnection("jdbc:postgresql://localhost/" + DBNAME, DBLOGIN, DBPASSWORD);

        } catch (SQLException e) {

            System.out.println("Проблема с соединением");
            e.printStackTrace();

        }
        return connection;

    }

    public ResultSet getData(String data, String table) {

        Connection connection = initConnection();
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery("SELECT " + data + " FROM " + table);

        } catch (SQLException e) {

            System.out.println("Проблема с запросом");
            e.printStackTrace();
        }

        return result;
    }

    public PreparedStatement setData(String sql, String table) {

        Connection connection = initConnection();
        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement("INSERT INTO " + table + sql);

        } catch (SQLException e) {

            System.out.println("Проблема с запросом");
            e.printStackTrace();

        }

        return ps;
    }
}