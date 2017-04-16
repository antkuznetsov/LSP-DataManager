package ru.innopolis.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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

}
