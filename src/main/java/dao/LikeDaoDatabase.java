package dao;

import database.DatabaseConnection;
import entity.Like;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LikeDaoDatabase implements DAO<Like>{
    private final Connection connection = DatabaseConnection.getConnection();

    @SneakyThrows
    @Override
    public List<Like> getAll(){
        List<Like> likes = new ArrayList<>();
        String query = "select * from \"like\"";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            int from = resultSet.getInt("id");
            int to = resultSet.getInt("like_id");
            likes.add(new Like(from, to));
        }
        return likes;
    }

    @SneakyThrows
    @Override
    public void insert(Like like){
        String query = "insert into \"like\" values(?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, like.getFrom());
        statement.setInt(2, like.getTo());
        statement.execute();
    }

    @SneakyThrows
    public void remove(Like like){
        String query = "delete from \"like\" where id = ? and like_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, like.getFrom());
        statement.setInt(2, like.getTo());
        statement.execute();
    }

    @Override
    public void remove(int id){
    }

    @Override
    public Like get(int id){
        return null;
    }

}
