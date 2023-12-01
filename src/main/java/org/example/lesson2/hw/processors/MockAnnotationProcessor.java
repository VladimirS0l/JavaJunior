package org.example.lesson2.hw.processors;

import org.example.lesson2.hw.PersonRepository;
import org.example.lesson2.hw.annotation.Mock;

import java.lang.reflect.Field;

public class MockAnnotationProcessor {
    public static void process(Object target) throws IllegalAccessException {
        Class<?> clazz = target.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Mock.class)) {
                field.setAccessible(true);
                field.set(target, new PersonRepository());
            }
        }
    }
}
