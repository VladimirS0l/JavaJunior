package org.example.lesson4.hw;

import org.example.lesson4.hw.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaskOneJDBC {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public String createTableBook() {
        try {
            Connection connection = DriverManager
                    .getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute("""
            CREATE TABLE IF NOT EXISTS books
            (
                id bigserial primary key,
                book_name varchar(255),
                author varchar(255)
            )
            """);
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Create table";
    }

    public String saveBook(Book book) {
        try {
            Connection connection = DriverManager
                    .getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO books (book_name, author) VALUES ('").append(book.getNameBook())
                            .append("', '").append(book.getAuthor()).append("');");
            statement.execute(sb.toString());
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Book add in db";
    }

    public Book findBook(String author) {
        Book book = null;
        try {
            Connection connection = DriverManager
                    .getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT * from books WHERE author='" + author + "';");
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String bookName = resultSet.getString("book_name");
                String authorDb = resultSet.getString("author");
                book = new Book(id, bookName, authorDb);
            }

            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;
    }

}
