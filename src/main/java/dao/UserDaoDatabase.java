package dao;

import database.DatabaseConnection;
import entity.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoDatabase implements DAO<User> {
    private final Connection connection = DatabaseConnection.getConnection();

    @SneakyThrows
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "select * from \"user\"";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String photoLink = resultSet.getString("photoLink");
            String mail = resultSet.getString("mail");
            String password = resultSet.getString("password");
            Date date = resultSet.getDate("last_login");
            String profession = resultSet.getString("profession");
            if (date == null) {
                users.add(new User(id, name, surname, photoLink, mail, password, null, profession));
            } else {
                users.add(new User(id, name, surname, photoLink, mail, password, date.toLocalDate(), profession));
            }

        }
        return users;
    }

    @SneakyThrows
    @Override
    public User get(int id) {
        String query = "select * from \"user\" where id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String photoLink = resultSet.getString("photoLink");
            String mail = resultSet.getString("mail");
            String password = resultSet.getString("password");
            Date date = resultSet.getDate("last_login");
            String profession = resultSet.getString("profession");
            if (date == null) {
                return new User(id, name, surname, photoLink, mail, password, null, profession);
            }
            return new User(id, name, surname, photoLink, mail, password, date.toLocalDate(), profession);
        }
        return new User();
    }

    @SneakyThrows
    @Override
    public void insert(User user) {
        String query = "insert into \"user\" (name, surname, photoLink, mail, password) " +
                "values (?, ?, ?, ? , ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, user.getSurname());
        statement.setString(3, user.getPhotoLink());
        statement.setString(4, user.getMail());
        statement.setString(5, user.getPassword());
        statement.execute();
    }

    @SneakyThrows
    @Override
    public void remove(int id) {
        String query = "delete from \"user\" where id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.execute();
    }

    @SneakyThrows
    public void updateLastLogin(int id) {
        String query = "UPDATE \"user\" "
                + "SET last_login = ? "
                + "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setObject(1, LocalDate.now());
        statement.setInt(2, id);
        statement.execute();
    }
}
