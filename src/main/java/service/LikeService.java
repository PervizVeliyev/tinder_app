package service;

import dao.LikeDaoDatabase;
import dao.UserDaoDatabase;
import entity.Like;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class LikeService {
    private final LikeDaoDatabase likeDaoDatabase = new LikeDaoDatabase();
    private final UserDaoDatabase userDaoDatabase = new UserDaoDatabase();

    public List<User> getAllLikedUsers(int id){
        List<Like> likes = likeDaoDatabase.getAll();
        List<User> users = new ArrayList<>();
        for(Like like : likes){
            if(like.getFrom() == id) users.add(userDaoDatabase.get(like.getTo()));
        }
        return users;
    }

    public List<Like> getAllLikes(){
        return likeDaoDatabase.getAll();
    }

    public void removeLike(Like like){
        likeDaoDatabase.remove(like);
    }

    public void insertLike(Like like){
        likeDaoDatabase.insert(like);
    }
}
