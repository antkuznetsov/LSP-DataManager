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

@XmlRootElement(name = "comments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Comments {

    @XmlElement(name = "comment")
    private List<Comment> comments;

    public Comments() {
        comments = new ArrayList<>(128);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Comments importComments() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File file = new File("data/" + this.getClass().getSimpleName() + ".xml");
        Comments tempComments = (Comments) parser.getObject(file, this.getClass());
        return tempComments;
    }

    public void exportComments() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File f = new File("data/" + this.getClass().getSimpleName() + ".xml");
        parser.saveObject(f, this);
    }

    public void importCommentsDB() throws SQLException {
        DB db = new DB();
        ResultSet r = db.getData("*", "comments");
        while (r.next()) {
            Comment comment = new Comment(
                    r.getInt("id"),
                    r.getString("content"),
                    r.getInt("author_id"),
                    r.getInt("lesson_id")
            );
            comments.add(comment);
        }
    }

    public void exportCommentsDB() throws SQLException {
        DB db = new DB();
        PreparedStatement ps = db.setData(
                "(id, content, author_id, lesson_id) VALUES (?, ?, ?, ?)",
                "comments"
        );

        for (Comment c : comments) {

            ps.setInt(1, c.getId());
            ps.setString(2, c.getContent());
            ps.setInt(3, c.getAuthorId());
            ps.setInt(4, c.getAuthorId());

            ps.executeUpdate();

        }
    }
}