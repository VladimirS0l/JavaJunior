package org.example.lesson3.seminar;

import com.fasterxml.jackson.databind.ext.NioPathSerializer;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class InputOutputMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Path path = Path.of("pom.xml");
//        InputStream inputStream = Files.newInputStream(path);
//        byte[] array = inputStream.readAllBytes();
//
//        inputStream.close();
//
//        String content = new String(array);
//        System.out.println(content);
//
//        Path path1 = Path.of("output.txt");
//
//        try (OutputStream outputStream =
//                     Files.newOutputStream(path1, StandardOpenOption.APPEND)) {
//            String outputStr = "asdla sdka snd;ona kd.auh duashd uakd.a nskfjn ksfj";
//            outputStream.write(outputStr.getBytes());
//        }

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
