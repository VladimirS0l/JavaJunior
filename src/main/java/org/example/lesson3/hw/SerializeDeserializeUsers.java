package org.example.lesson3.hw;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializeDeserializeUsers {


    public void userSerialize(Path path, Object object) throws IOException {
        Files.createFile(path);
        OutputStream outputStream = Files.newOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    public Object userDeserialize(Path path) throws IOException, ClassNotFoundException {
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        Object object = null;
        try {
            inputStream = Files.newInputStream(path);
        } catch (Exception ex) {
            System.out.println("Файл не найден");
        }
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (Exception ex) {
            System.out.println("Файл поврежден");
        }
        if (objectInputStream != null) {
            object = objectInputStream.readObject();
            Files.delete(path);
            objectInputStream.close();
        }
        return object;
    }


}
