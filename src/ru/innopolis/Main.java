package ru.innopolis;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }

    public static void main(String[] args) throws JAXBException, SQLException {

        Application app = new Application();

        //app.XML2DB();
        app.DB2XML();

        System.out.println(app.getUsers());
        System.out.println(app.getCourses());
        System.out.println(app.getLessons());
        System.out.println(app.getComments());
    }

}