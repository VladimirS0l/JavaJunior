package org.example.lesson3.hw.processor;

import org.example.lesson3.hw.annotation.PostConstuct;

import java.lang.reflect.Method;

public class PostConstructAnnotationProcessor {
    public static void process(Object target) throws Exception {
        Class<?> clazz = target.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstuct.class)) {
                method.setAccessible(true);
                method.invoke(target);
            }
        }
    }
}
