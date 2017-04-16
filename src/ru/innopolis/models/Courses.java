package ru.innopolis.models;

import ru.innopolis.conf.DB;
import ru.innopolis.utils.JaxbParser;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kuznetsov on 16/04/2017.
 */

@XmlRootElement(name = "courses")
@XmlAccessorType(XmlAccessType.FIELD)
public class Courses {

    @XmlElement(name = "course")
    private List<Course> courses;

    public Courses() {
        courses = new ArrayList<>(128);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Courses importCourses() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File file = new File("data/" + this.getClass().getSimpleName() + ".xml");
        Courses tempCourses = (Courses) parser.getObject(file, this.getClass());
        return tempCourses;
    }

    public void exportCourses() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File f = new File("data/" + this.getClass().getSimpleName() + ".xml");
        parser.saveObject(f, this);
    }

    public void importCoursesDB() throws SQLException {
        DB db = new DB();
        ResultSet r = db.getData("*", "courses");
        while (r.next()) {
            Course course = new Course(
                    r.getInt("id"),
                    r.getString("title"),
                    r.getString("description"),
                    r.getInt("author_id")
            );
            courses.add(course);
        }
    }

    public void exportCoursesDB() throws SQLException {
        DB db = new DB();
        PreparedStatement ps = db.setData(
                "(id, title, description, author_id) VALUES (?, ?, ?, ?)",
                "courses"
        );

        for (Course c : courses) {

            ps.setInt(1, c.getId());
            ps.setString(2, c.getTitle());
            ps.setString(3, c.getDescription());
            ps.setInt(4, c.getAuthorId());

            ps.executeUpdate();

        }
    }
}