package org.example.lesson3.hw;

import org.example.lesson3.hw.annotation.PostConstuct;
import org.example.lesson3.hw.annotation.PreDestroy;
import org.example.lesson3.hw.model.Comment;
import org.example.lesson3.hw.model.Task;
import org.example.lesson3.hw.model.User;
import org.example.lesson3.hw.exception.ResourceNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SerializeDeserializeUsers {
    private List<User> users;
    private Path path;


    @PostConstuct
    public void init() throws IOException {
        path = Path.of(this.getClass().getName() + UUID.randomUUID() + ".txt");
        Files.createFile(path);
        users = new ArrayList<>();

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

    }

    public void userSerialize() throws IOException {
        OutputStream outputStream = Files.newOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.close();
    }

    public void userDeserialize() throws IOException, ClassNotFoundException {
        InputStream inputStream = Files.newInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        List<User> users1 = new ArrayList<>((List<User>) objectInputStream.readObject());

        users1.forEach(System.out::println);
    }

    @PreDestroy
    public void ending() {
        try {
            Files.delete(path);
        } catch (ResourceNotFoundException exception) {
            System.out.println("Файл по указанному пути не найден");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
