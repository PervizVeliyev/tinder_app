package dao;

import database.DatabaseConnection;
import entity.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoDatabase implements DAO<User>{
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
            users.add(new User(id, name, surname, photoLink, mail, password));
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
            return new User(id, name, surname, photoLink, mail, password);
        }
        return new User();
    }

    @SneakyThrows
    @Override
    public void insert(User user){
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
        statement.execute();
    }
}
