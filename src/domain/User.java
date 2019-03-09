package domain;

import java.util.Date;
import java.util.List;

public class User {
    private String email;
    private String name;
    private String surname;
    private String password;
    private Date resgistrationDate;
    private List<Video> videos;

    public User(String email) {
        this.email = email;
        this.resgistrationDate = new Date();
        // asignar la fecha y hora current en el local adecuado
    }

    public User(String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;

        this.resgistrationDate = new Date();
        // asignar la fecha y hora current en el local adecuado
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getResgistrationDate() {
        return resgistrationDate;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public String toString(){
        return "email : " + this.email + "; name : " + this.name + "; surname : " + this.surname + "; password : " + this.password;
    }
}
