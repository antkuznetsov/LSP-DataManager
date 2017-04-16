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

@XmlRootElement(name = "lessons")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lessons {

    @XmlElement(name = "lesson")
    private List<Lesson> lessons;

    public Lessons() {
        lessons = new ArrayList<>(128);
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

}