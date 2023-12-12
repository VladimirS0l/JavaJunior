package org.example.lesson3.hw.model;

import java.io.Serializable;
import java.util.List;

public class Task implements Serializable {
    private int id;
    private String title;
    private String description;
    private List<Comment> comments;

    public Task(int id, String title, String description, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.comments = comments;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "\n\tTask{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", comments=" + comments +
                '}';
    }
}
