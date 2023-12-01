package org.example.lesson2.seminar.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIntegerProcessor {
    public static void processObject(Object object) {
        Class<?> aClass = object.getClass();
        for (Field field: aClass.getDeclaredFields()) {
            if (Integer.class.isAssignableFrom(field.getType()) &&
            field.isAnnotationPresent(RandomInteger.class)) {
                RandomInteger annotation = field.getAnnotation(RandomInteger.class);
                int min = annotation.min();
                int max = annotation.max();
                int random = min + ThreadLocalRandom.current().nextInt(max - min);
                field.setAccessible(true);
                try {
                    field.set(object, random);
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
