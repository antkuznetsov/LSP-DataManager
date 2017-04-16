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

}