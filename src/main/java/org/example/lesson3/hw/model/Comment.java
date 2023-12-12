package org.example.lesson3.hw.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int id;
    private String message;
    private String username;

    public Comment(int id, String message, String username) {
        this.id = id;
        this.message = message;
        this.username = username;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
