package ru.innopolis;

import ru.innopolis.models.*;
import ru.innopolis.utils.JaxbParser;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Main {

    static Users users = new Users();
    static Courses courses = new Courses();
    static Lessons lessons = new Lessons();
    static Comments comments = new Comments();

    public static void main(String[] args) throws JAXBException {

        //DB db = new DB();
        //db.initConnection();
        //db.get();

        /*
        Application app = new Application();

        app.addUser(1, "Антон", "Кузнецов", "ak@mail.ru", "123456", 1);
        app.addUser(2, "Александра", "Воробьёва", "av@mail.ru", "987654", 2);

        app.addCourse(1, "Основы Java", "Вы узнаете много нового", 1);

        app.addLesson(1, "История и развитие языка Java", "Lorem ipsum", 1);
        app.addLesson(2, "Краткий обзор Java", "Dolor sit amet", 1);

        app.addComment(1, "Очень полезный курс", 2, 1);

        System.out.println(app.getUsers());
        System.out.println(app.getCourses());
        System.out.println(app.getLessons());
        System.out.println(app.getComments());

        app.dataExport();
        */

        User ak = new User(1, "Антон", "Кузнецов", "ak@mail.ru", "123456", 1);
        User av = new User(2, "Александра", "Воробьёва", "av@mail.ru", "987654", 2);

        Course course = new Course(1, "Основы Java", "Вы узнаете много нового", 1);

        Lesson l1 = new Lesson(1, "История и развитие языка Java", "Lorem ipsum", 1);
        Lesson l2 = new Lesson(2, "Краткий обзор Java", "Dolor sit amet", 1);

        Comment comment = new Comment(1, "Очень полезный курс", 2, 1);

        users.addUser(ak);
        users.addUser(av);

        courses.addCourse(course);

        lessons.addLesson(l1);
        lessons.addLesson(l2);

        comments.addComment(comment);

        System.out.println(users.getUsers());
        System.out.println(courses.getCourses());
        System.out.println(lessons.getLessons());
        System.out.println(comments.getComments());

        JaxbParser parser = new JaxbParser();

        File f1 = new File("data/users.xml");
        File f2 = new File("data/courses.xml");
        File f3 = new File("data/lessons.xml");
        File f4 = new File("data/comments.xml");

        parser.saveObject(f1, users);
        parser.saveObject(f2, courses);
        parser.saveObject(f3, lessons);
        parser.saveObject(f4, comments);

    }
}