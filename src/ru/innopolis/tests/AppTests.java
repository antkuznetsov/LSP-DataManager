package ru.innopolis.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.innopolis.Application;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kuznetsov on 17/04/2017.
 */

public class AppTests {

    private static Application app;

    @BeforeClass
    public static void init() {
        app = new Application();
    }

    @Test
    public void addUserTest() {

        app.addUser(1, "Антон", "Кузнецов", "ak@mail.ru", "123456", 1);

        assertEquals(1, app.getUsers().size());

    }

    @Test
    public void addCourseTest() {

        app.addCourse(1, "Основы Java", "Вы узнаете много нового", 1);

        assertEquals(1, app.getCourses().size());

    }

    @Test
    public void addLessonTest() {

        app.addLesson(1, "История и развитие языка Java", "Lorem ipsum", 1);

        assertEquals(1, app.getLessons().size());

    }

    @Test
    public void addCommentTest() {

        app.addComment(1, "Очень полезный курс", 2, 1);

        assertEquals(1, app.getComments().size());

    }

}
