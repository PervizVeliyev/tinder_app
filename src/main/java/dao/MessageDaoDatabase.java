package dao;

import database.DatabaseConnection;
import entity.Message;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoDatabase implements DAO<Message> {
    private final Connection connection = DatabaseConnection.getConnection();

    @SneakyThrows
    public List<Message> getAllMessages(int sender, int receiver) {
        List<Message> messages = new ArrayList<>();
        String query = "select * from message " +
                "where (sender = ? and receiver = ?) " +
                "or (sender = ? and receiver = ?)\n" +
                "order by id asc";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, sender);
        statement.setInt(2, receiver);
        statement.setInt(3, receiver);
        statement.setInt(4, sender);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int from = resultSet.getInt("sender");
            int to = resultSet.getInt("receiver");
            String content = resultSet.getString("content");
            messages.add(new Message(from, to, content));
        }
        return messages;
    }

    @SneakyThrows
    @Override
    public void insert(Message message) {
        String query = "insert into message values (default, ?, ?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, message.getSender());
        statement.setInt(2, message.getReceiver());
        statement.setString(3, message.getContent());
        statement.setObject(4, LocalDate.now());
        statement.execute();
    }

    @SneakyThrows
    @Override
    public List<Message> getAll() {
        return null;
    }

    @SneakyThrows
    @Override
    public Message get(int id) {
        return null;
    }

    @SneakyThrows
    @Override
    public void remove(int id) {
    }
}
