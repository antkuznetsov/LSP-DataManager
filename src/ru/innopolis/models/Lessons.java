package ru.innopolis.models;

import ru.innopolis.utils.JaxbParser;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
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

    public Lessons importLessons() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File file = new File("data/" + this.getClass().getSimpleName() + ".xml");
        Lessons tempLessons = (Lessons) parser.getObject(file, this.getClass());
        return tempLessons;
    }

    public void exportLessons() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File file = new File("data/" + this.getClass().getSimpleName() + ".xml");
        parser.saveObject(file, this);
    }

}