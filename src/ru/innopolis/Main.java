package ru.innopolis;

import ru.innopolis.models.Comment;
import ru.innopolis.models.Course;
import ru.innopolis.models.Lesson;
import ru.innopolis.models.User;

public class Main {

    public static void main(String[] args) {

        //DB db = new DB();
        //db.initConnection();
        //db.get();

        User ak = new User(1, "Антон", "Кузнецов", "ak@mail.ru", "123456", 1);
        User av = new User(2, "Александра", "Воробьёва", "av@mail.ru", "987654", 2);

        Course course = new Course(1, "Основы Java", "Вы узнаете много нового", 1);

        Lesson l1 = new Lesson(1, "История и развитие языка Java", "Lorem ipsum", 1);
        Lesson l2 = new Lesson(1, "Краткий обзор Java", "Dolor sit amet", 1);

        Comment c1 = new Comment(1, "Очень полезный курс", 2, 1);

        System.out.println(ak);
        System.out.println(av);
        System.out.println();
        System.out.println(course);
        System.out.println();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println();
        System.out.println(c1);

    }
}