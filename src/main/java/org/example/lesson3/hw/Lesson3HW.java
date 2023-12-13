package org.example.lesson3.hw;

import org.example.lesson3.hw.model.Comment;
import org.example.lesson3.hw.model.Task;
import org.example.lesson3.hw.model.User;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Написать класс с двумя методами:
 * 1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл. Название файл - class.getName()
 * + "_" + UUID.randomUUID().toString()
 * 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.
 * Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.
 */

public class Lesson3HW {
    public static void main(String[] args) throws Exception {
        var serializeDeserializeUsers = new SerializeDeserializeUsers();

        var path = Path.of(serializeDeserializeUsers.getClass().getName()
                + UUID.randomUUID() + ".txt");

        var users = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            List<Task> tasks = new ArrayList<>();
            for (int j = 0; j < random.nextInt(3); j++) {
                List<Comment> comments = new ArrayList<>();
                for (int k = 0; k < random.nextInt(3); k++) {
                    comments.add(new Comment(k, "Message#"+k, "Username#"+k));
                }
                tasks.add(new Task(j, "Title#"+j, "Description"+j, comments));
            }
            users.add(new User(i, "Name#"+i, (20+i), tasks));
        }

        serializeDeserializeUsers.userSerialize(path, users);
        var result = serializeDeserializeUsers.userDeserialize(path);
        System.out.println(result);

    }
}
