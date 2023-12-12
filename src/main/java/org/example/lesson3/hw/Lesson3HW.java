package org.example.lesson3.hw;

import org.example.lesson3.hw.processor.PostConstructAnnotationProcessor;
import org.example.lesson3.hw.processor.PreDestroyAnnotationProcessor;

/**
 * Написать класс с двумя методами:
 * 1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл. Название файл - class.getName()
 * + "_" + UUID.randomUUID().toString()
 * 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.
 * Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.
 */

public class Lesson3HW {

    public static void main(String[] args) throws Exception {
        SerializeDeserializeUsers serializeDeserializeUsers = new SerializeDeserializeUsers();
        PostConstructAnnotationProcessor.process(serializeDeserializeUsers);
        serializeDeserializeUsers.userSerialize();
        serializeDeserializeUsers.userDeserialize();
        PreDestroyAnnotationProcessor.process(serializeDeserializeUsers);
    }
}
