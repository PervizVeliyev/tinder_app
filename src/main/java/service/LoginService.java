package service;

import dao.UserDaoDatabase;
import entity.User;

import java.util.List;

public class LoginService {
    private final UserDaoDatabase userDaoDatabase = new UserDaoDatabase();

    public User getUser(String mail, String password){
        List<User> users = userDaoDatabase.getAll();

        return users.stream()
                .filter(user -> user.getMail().equalsIgnoreCase(mail) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
