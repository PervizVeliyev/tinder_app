package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<A> {
    List<A> getAll() throws SQLException;

    A get(int id) throws SQLException;

    void insert(A a) throws SQLException;

    void remove(int id) throws SQLException;
}
