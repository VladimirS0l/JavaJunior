package org.example.lesson4.hw;

import org.example.lesson4.hw.entity.Author;
import org.example.lesson4.hw.entity.Book;
import org.example.lesson4.hw.entity.BookAdditional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class TaskThreeJPA {

    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public Author saveAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }

    public Author findAuthorById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.get(Author.class, id);
        session.getTransaction().commit();
        session.close();
        return author;
    }

    public BookAdditional saveBookAdd(BookAdditional book, Long authorId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = findAuthorById(authorId);
        book.setAuthor(author);
        session.persist(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    public List<BookAdditional> findAllByAuthorId(Long id) {
        List<BookAdditional> books;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.get(Author.class, id);
        books = author.getBooks();
        session.getTransaction().commit();
        session.close();
        return books;
    }
}
