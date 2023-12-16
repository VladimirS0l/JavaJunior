package org.example.lesson4.hw;

import org.example.lesson4.hw.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class TaskTwoJPA {
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public String saveBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(book);
        session.getTransaction().commit();
        session.close();
        return "Book save";
    }

    public List<Book> findBookByAuthor(String authorFind) {
        List<Book> books = new ArrayList<>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        books = session
                .createQuery("SELECT b FROM Book b WHERE author=?1", Book.class)
                .setParameter(1, authorFind)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return books;
    }
}
