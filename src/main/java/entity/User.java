package entity;

public class User {
    private int id;
    private String name;
    private String surname;
    private String photoLink;
    private String mail;
    private String password;

    public User(int id, String name, String surname, String photoLink, String mail, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.photoLink = photoLink;
        this.mail = mail;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
