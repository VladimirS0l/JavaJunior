package org.example.lesson4.hw.entity;



import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "author_name")
    private String authorName;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<BookAdditional> books;

    public Author(Long id, String authorName, List<BookAdditional> books) {
        this.id = id;
        this.authorName = authorName;
        this.books = books;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<BookAdditional> getBooks() {
        return books;
    }

    public void setBooks(List<BookAdditional> books) {
        this.books = books;
    }

//    @Override
//    public String toString() {
//        return "Author{" +
//                "id=" + id +
//                ", authorName='" + authorName + '\'' +
//                ", books=" + books +
//                '}';
//    }
}
