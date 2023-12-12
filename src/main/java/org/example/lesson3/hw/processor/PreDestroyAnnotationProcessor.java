package org.example.lesson3.hw.processor;

import org.example.lesson3.hw.annotation.PreDestroy;

import java.lang.reflect.Method;

public class PreDestroyAnnotationProcessor {
    public static void process(Object target) throws Exception {
        Class<?> clazz = target.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PreDestroy.class)) {
                method.setAccessible(true);
                method.invoke(target);
            }
        }
    }
}
