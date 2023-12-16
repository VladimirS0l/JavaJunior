package org.example.lesson4.hw;

import org.example.lesson4.hw.entity.Author;
import org.example.lesson4.hw.entity.Book;
import org.example.lesson4.hw.entity.BookAdditional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Задания необходимо выполнять на ЛЮБОЙ СУБД (postgres, mysql, sqllite, h2, ...)
 *
 * 1. С помощью JDBC выполнить:
 * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
 * 1.2 Добавить в таблицу 10 книг
 * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet
 *
 * 2. С помощью JPA(Hibernate) выполнить:
 * 2.1 Описать сущность Book из пункта 1.1
 * 2.2 Создать Session и сохранить в таблицу 10 книг
 * 2.3 Выгрузить список книг какого-то автора
 *
 * 3.* Создать сущность Автор (id biging, name varchar), и в сущности Book сделать поле типа Author (OneToOne)
 * 3.1 * Выгрузить Список книг и убедиться, что поле author заполнено
 * 3.2 ** В классе Author создать поле List<Book>, которое описывает список всех книг этого автора. (OneToMany)
 */

public class Lesson4Main {
    public static void main(String[] args) {
        //Task 1
//        TaskOneJDBC taskOne = new TaskOneJDBC();
//        System.out.println(taskOne.createTableBook());
//
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(taskOne.saveBook(new Book(1L, "BookName#"+i, "Author#"+i)));
//        }

//        System.out.println(taskOne.findBook("Author#8"));

        //Task 2
//        TaskTwoJPA taskTwoJPA = new TaskTwoJPA();

//        for (int i = 0; i < 10; i++) {
//            taskTwoJPA.saveBook(new Book(
//                    null,
//                    "BookJpa#"+i,
//                    "Author#"+
//                            ThreadLocalRandom.current().nextInt(3)));
//        }
//
//        List<Book> bookByAuthor = taskTwoJPA.findBookByAuthor("Author#2");
//        bookByAuthor.forEach(System.out::println);

        //Task 3
        //Чтобы не портить работоспособность Задач 1,2 была создана доп.сущность книги BookAdditional

        TaskThreeJPA taskThreeJPA = new TaskThreeJPA();
        Author author1 = new Author(null, "AuthorJpa#1", new ArrayList<>());
        Author author2 = new Author(null, "AuthorJpa#2", new ArrayList<>());
        taskThreeJPA.saveAuthor(author1);
        taskThreeJPA.saveAuthor(author2);

        for (int i = 0; i < 10; i++) {
            Long id = ThreadLocalRandom.current().nextLong(1, 3);
            taskThreeJPA.saveBookAdd(
                    new BookAdditional(null, "BookAdd#"+i, new Author()), id);
        }

        List<BookAdditional> allBooksByAuthorId = taskThreeJPA.findAllByAuthorId(1L);
        for (BookAdditional book: allBooksByAuthorId) {
            System.out.println("Book: id-"
                    + book.getId() + ", book name-"
                    + book.getNameBook() + ", author-"
                    + book.getAuthor().getAuthorName());
        }
    }


}
