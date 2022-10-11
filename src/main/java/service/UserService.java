package service;

import dao.UserDaoDatabase;
import entity.User;

import java.util.List;

public class UserService {
    private final UserDaoDatabase userDaoDatabase = new UserDaoDatabase();

    public List<User> getAllUsers(){
        return userDaoDatabase.getAll();
    }


}
