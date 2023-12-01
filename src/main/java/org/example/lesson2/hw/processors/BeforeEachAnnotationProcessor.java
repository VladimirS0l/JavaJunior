package org.example.lesson2.hw.processors;

import org.example.lesson2.hw.annotation.BeforeEach;

import java.lang.reflect.Method;

public class BeforeEachAnnotationProcessor {
    public static void process(Object target) throws Exception {
        Class<?> clazz = target.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeEach.class)) {
                method.setAccessible(true);
                method.invoke(target);
            }
        }
    }
}
