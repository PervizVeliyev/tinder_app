package entity;

public class User {
    private int id;
    private String name;
    private String surname;
    private String photoLink;

    public User(int id, String name, String surname, String photoLink) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.photoLink = photoLink;
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
}
