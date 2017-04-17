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

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    private static final Logger LOGGER = Logger.getLogger(Users.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }

    @XmlElement(name = "user")
    private List<User> users;

    public Users() {
        users = new ArrayList<>(128);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public Users importUsers() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File file = new File("data/" + this.getClass().getSimpleName() + ".xml");
        Users tempUsers = (Users) parser.getObject(file, this.getClass());
        return tempUsers;
    }

    public void exportUsers() throws JAXBException {
        JaxbParser parser = new JaxbParser();
        File file = new File("data/" + this.getClass().getSimpleName() + ".xml");
        parser.saveObject(file, this);
    }

    public void importUsersDB() throws SQLException {
        DB db = new DB();
        ResultSet r = db.getData("*", "users");
        while (r.next()) {
            User user = new User(
                    r.getInt("id"),
                    r.getString("name"),
                    r.getString("last_name"),
                    r.getString("email"),
                    r.getString("password"),
                    r.getInt("group_id")
            );
            users.add(user);
        }
    }

    public void exportUsersDB() throws SQLException {
        DB db = new DB();
        PreparedStatement ps = db.setData(
                "(id, name, last_name, email, password, group_id) VALUES (?, ?, ?, ?, ?, ?)",
                "users"
        );

        for (User u : users) {

            ps.setInt(1, u.getId());
            ps.setString(2, u.getName());
            ps.setString(3, u.getLastName());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPassword());
            ps.setInt(6, u.getGroup());

            ps.executeUpdate();

        }
    }
}