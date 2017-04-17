package ru.innopolis.models;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Kuznetsov on 13/04/2017.
 */

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    private static final Logger LOGGER = Logger.getLogger(User.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private int group;

    public User(int id, String name, String lastName, String email, String password, int group) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.group = group;
    }

    public User() {
        this.id = -1;
        this.name = null;
        this.lastName = null;
        this.email = null;
        this.password = null;
        this.group = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", group=" + group +
                '}';
    }
}