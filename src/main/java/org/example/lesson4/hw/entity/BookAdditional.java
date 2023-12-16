package org.example.lesson4.hw.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "books_add")
public class BookAdditional implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "book_name")
    private String nameBook;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public BookAdditional(Long id, String nameBook, Author author) {
        this.id = id;
        this.nameBook = nameBook;
        this.author = author;
    }

    public BookAdditional() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

//    @Override
//    public String toString() {
//        return "BookAdditional{" +
//                "id=" + id +
//                ", nameBook='" + nameBook + '\'' +
//                ", author=" + author +
//                '}';
//    }
}
