package org.example.lesson2.hw.processors;

import org.example.lesson2.hw.annotation.Mock;

import java.lang.reflect.Field;

public class MockAnnotationProcessor {
    public static void process(Object target) throws IllegalAccessException {
        Class<?> clazz = target.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Mock.class)) {
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                Object mockObject = createMockObject(fieldType);
                field.set(target, mockObject);
            }
        }
    }

    private static Object createMockObject(Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось создать мок объект для класса: "
                    + clazz.getName(), e);
        }
    }

}
