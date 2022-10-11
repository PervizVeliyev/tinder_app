package service;

import dao.MessageDaoDatabase;
import entity.Message;

import java.util.List;

public class MessageService {
    private final MessageDaoDatabase messageDaoDatabase = new MessageDaoDatabase();

    public List<Message> getAllMessages(int sender, int receiver){
        return messageDaoDatabase.getAllMessages(sender, receiver);
    }

    public void insertMessage(Message message){
        messageDaoDatabase.insert(message);
    }
}
