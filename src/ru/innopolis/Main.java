package ru.innopolis;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws JAXBException, SQLException {

        Application app = new Application();

        /*
        app.addUser(1, "Антон", "Кузнецов", "ak@mail.ru", "123456", 1);
        app.addUser(2, "Александра", "Воробьёва", "av@mail.ru", "987654", 2);

        app.addCourse(1, "Основы Java", "Вы узнаете много нового", 1);

        app.addLesson(1, "История и развитие языка Java", "Lorem ipsum", 1);
        app.addLesson(2, "Краткий обзор Java", "Dolor sit amet", 1);

        app.addComment(1, "Очень полезный курс", 2, 1);
        */

        app.XML2DB();
        app.DB2XML();

        System.out.println(app.getUsers());
        System.out.println(app.getCourses());
        System.out.println(app.getLessons());
        System.out.println(app.getComments());
    }

}