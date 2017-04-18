package ru.innopolis.conf;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.*;

/**
 * Created by Kuznetsov on 13/04/2017.
 */

/**
 * Класс для работы с БД
 */
public class DB {

    private static final Logger LOGGER = Logger.getLogger(DB.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }

    private final String DBNAME = "lsp-1";
    private final String DBLOGIN = "postgres";
    private final String DBPASSWORD = "656450";

    /**
     * Возвращает соединение с БД
     * @return Connection
     */
    public Connection initConnection() {

        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            LOGGER.debug("Проблема с драйвером");

        }

        try {

            connection = DriverManager.getConnection("jdbc:postgresql://localhost/" + DBNAME, DBLOGIN, DBPASSWORD);

        } catch (SQLException e) {

            LOGGER.debug("Проблема с соединением");

        }
        return connection;

    }

    /**
     * Получение данных из БД
     * @param data — список полей для выборки из БД
     * @param table — название таблицы
     * @return ResultSet
     */
    public ResultSet getData(String data, String table) {

        Connection connection = initConnection();
        ResultSet result = null;

        try {

            Statement statement = connection.createStatement();
            result = statement.executeQuery("SELECT " + data + " FROM " + table);

        } catch (SQLException e) {

            LOGGER.debug("Проблема с запросом");

        }

        return result;
    }

    /**
     * Добавление данных в БД
     * @param sql — выполняемый запрос
     * @param table — название таблицы
     * @return PreparedStatement
     */
    public PreparedStatement setData(String sql, String table) {

        Connection connection = initConnection();
        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement("INSERT INTO " + table + sql);

        } catch (SQLException e) {

            LOGGER.debug("Проблема с запросом");

        }

        return ps;
    }
}