package entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class User {
    private int id;
    private String name;
    private String surname;
    private String photoLink;
    private String mail;
    private String password;
    private LocalDate lastLogin;
    private String profession;

    public User(int id, String name, String surname, String photoLink, String mail, String password, LocalDate lastLogin, String profession) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.photoLink = photoLink;
        this.mail = mail;
        this.password = password;
        this.lastLogin = lastLogin;
        this.profession = profession;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
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

    public String getLastLogin() {
        if (lastLogin == null) {
            return "unknown";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return lastLogin.format(formatter);
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

    public String getLastLoginGap() {
        if (lastLogin == null) return "unknown";
        long gap = DAYS.between(lastLogin, LocalDate.now());
        return gap > 0 ? String.valueOf(gap) + " days ago" : "recently";
    }
}
