package org.example.lesson3.seminar;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputOutputMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person vladimir = new Person(1, "Vladimir", 30);
        Path path = Path.of("person-serializable.txt");
        OutputStream outputStream = Files.newOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(vladimir);
        objectOutputStream.close();

        InputStream inputStream = Files.newInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Person readObject = (Person) objectInputStream.readObject();
        System.out.println(readObject);

    }
}
