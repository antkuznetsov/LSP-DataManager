package ru.innopolis;

import ru.innopolis.models.*;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by Kuznetsov on 15/04/2017.
 */

public class Application {

    private Users users = new Users();
    private Courses courses = new Courses();
    private Lessons lessons = new Lessons();
    private Comments comments = new Comments();

    public void addUser(int id, String name, String lastName, String email, String password, int group) {
        User user = new User(id, name, lastName, email, password, group);
        this.users.addUser(user);
    }

    public void addCourse(int id, String title, String description, int authorId) {
        Course course = new Course(id, title, description, authorId);
        this.courses.addCourse(course);
    }

    public void addLesson(int id, String title, String content, int courseId) {
        Lesson lesson = new Lesson(id, title, content, courseId);
        this.lessons.addLesson(lesson);
    }

    public void addComment(int id, String content, int authorId, int courseId) {
        Comment comment = new Comment(id, content, authorId, courseId);
        this.comments.addComment(comment);
    }

    public List<User> getUsers() {
        return this.users.getUsers();
    }

    public List<Course> getCourses() {
        return this.courses.getCourses();
    }

    public List<Lesson> getLessons() {
        return this.lessons.getLessons();
    }

    public List<Comment> getComments() {
        return this.comments.getComments();
    }

    public void importData() {

    }

    public void exportData() throws JAXBException {
        this.users.exportUsers();
        this.courses.exportCourses();
        this.lessons.exportLessons();
        this.comments.exportComments();
    }

}