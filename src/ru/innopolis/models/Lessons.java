package ru.innopolis.models;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
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

@XmlRootElement(name = "lessons")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lessons {

    private static final Logger LOGGER = Logger.getLogger(Lessons.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }

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

    /**
     * Импорт занятий из XML
     * @return
     * @throws JAXBException
     */
    public Lessons importLessons() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File file = new File("data/" + this.getClass().getSimpleName() + ".xml");
        Lessons tempLessons = (Lessons) parser.getObject(file, this.getClass());
        return tempLessons;
    }

    /**
     * Экспорт занятий в XML
     * @throws JAXBException
     */
    public void exportLessons() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File file = new File("data/" + this.getClass().getSimpleName() + ".xml");
        parser.saveObject(file, this);
    }

    /**
     * Импорт занятий из БД
     * @throws SQLException
     */
    public void importLessonsDB() throws SQLException {
        DB db = new DB();
        ResultSet r = db.getData("*", "lessons");
        while (r.next()) {
            Lesson lesson = new Lesson(
                    r.getInt("id"),
                    r.getString("title"),
                    r.getString("content"),
                    r.getInt("course_id")
            );
            lessons.add(lesson);
        }
    }

    /**
     * Экспорт занятий в БД
     * @throws SQLException
     */
    public void exportLessonsDB() throws SQLException {
        DB db = new DB();
        PreparedStatement ps = db.setData(
                "(id, title, content, course_id) VALUES (?, ?, ?, ?)",
                "lessons"
        );

        for (Lesson l : lessons) {

            ps.setInt(1, l.getId());
            ps.setString(2, l.getTitle());
            ps.setString(3, l.getContent());
            ps.setInt(4, l.getCourseId());

            ps.executeUpdate();

        }
    }
}