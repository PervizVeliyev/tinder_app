package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private int sender;
    private int receiver;
    private String content;
    private LocalDateTime date;


    public Message(int sender, int receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public Message(int sender, int receiver, String content, LocalDateTime localDateTime) {
        this(sender, receiver, content);
        this.date = localDateTime;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, h:mma");
        return date.format(formatter);
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
