package ru.innopolis.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kuznetsov on 15/04/2017.
 */

public class Application {

    private Set<User> users;
    private Set<Course> courses;
    private Set<Lesson> lessons;
    private Set<Comment> comments;

    public Application() {
        this.users = new HashSet<>(128);
        this.courses = new HashSet<>(128);
        this.lessons = new HashSet<>(128);
        this.comments = new HashSet<>(128);
    }

    public void addUser(int id, String name, String lastName, String email, String password, int group) {
        User user = new User(id, name, lastName, email, password, group);
        this.users.add(user);
    }

    public void addCourse(int id, String title, String description, int authorId) {
        Course course = new Course(id, title, description, authorId);
        this.courses.add(course);
    }

    public void addLesson(int id, String title, String content, int courseId) {
        Lesson lesson = new Lesson(id, title, content, courseId);
        this.lessons.add(lesson);
    }

    public void addComment(int id, String content, int authorId, int courseId) {
        Comment comment = new Comment(id, content, authorId, courseId);
        this.comments.add(comment);
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public Set<Comment> getComments() {
        return comments;
    }
}