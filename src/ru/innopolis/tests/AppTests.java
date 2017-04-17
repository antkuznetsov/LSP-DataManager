package ru.innopolis.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.innopolis.Application;
import ru.innopolis.models.Comment;
import ru.innopolis.models.Course;
import ru.innopolis.models.Lesson;
import ru.innopolis.models.User;

import static junit.framework.TestCase.assertTrue;
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
        User user = new User(1, "Антон", "Кузнецов", "ak@mail.ru", "123456", 1);
        assertTrue(app.getUsers().contains(user));
        User userFromList = app.getUsers().iterator().next();
        assertTrue(user.getId() == userFromList.getId());
        assertTrue(user.getName().equals(userFromList.getName()));
        assertTrue(user.getLastName().equals(userFromList.getLastName()));
        assertTrue(user.getEmail().equals(userFromList.getEmail()));
        assertTrue(user.getPassword().equals(userFromList.getPassword()));
        assertTrue(user.getGroup() == userFromList.getGroup());

    }

    @Test
    public void addCourseTest() {

        app.addCourse(1, "Основы Java", "Вы узнаете много нового", 1);
        assertEquals(1, app.getCourses().size());
        Course course = new Course(1, "Основы Java", "Вы узнаете много нового", 1);
        assertTrue(app.getCourses().contains(course));
        Course courseFromList = app.getCourses().iterator().next();
        assertTrue(course.getId() == courseFromList.getId());
        assertTrue(course.getTitle().equals(courseFromList.getTitle()));
        assertTrue(course.getDescription().equals(courseFromList.getDescription()));
        assertTrue(course.getAuthorId() == courseFromList.getAuthorId());

    }

    @Test
    public void addLessonTest() {

        app.addLesson(1, "История и развитие языка Java", "Lorem ipsum", 1);
        assertEquals(1, app.getLessons().size());
        Lesson lesson = new Lesson(1, "История и развитие языка Java", "Lorem ipsum", 1);
        assertTrue(app.getLessons().contains(lesson));
        Lesson lessonFromList = app.getLessons().iterator().next();
        assertTrue(lesson.getId() == lessonFromList.getId());
        assertTrue(lesson.getTitle().equals(lessonFromList.getTitle()));
        assertTrue(lesson.getContent().equals(lessonFromList.getContent()));
        assertTrue(lesson.getCourseId() == lessonFromList.getCourseId());

    }

    @Test
    public void addCommentTest() {

        app.addComment(1, "Очень полезный курс", 2, 1);
        assertEquals(1, app.getComments().size());
        Comment comment = new Comment(1, "Очень полезный курс", 2, 1);
        assertTrue(app.getComments().contains(comment));
        Comment commentFromList = app.getComments().iterator().next();
        assertTrue(comment.getId() == commentFromList.getId());
        assertTrue(comment.getContent().equals(commentFromList.getContent()));
        assertTrue(comment.getAuthorId() == commentFromList.getAuthorId());
        assertTrue(comment.getLessonId() == commentFromList.getLessonId());

    }

}