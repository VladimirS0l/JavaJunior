package org.example.lesson2.hw.processors;

import org.example.lesson2.hw.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestAnnotationProcessor {
    public static void process(Object target) {
        Class<?> clazz = target.getClass();
        Map<Integer, Method> treeMap = new TreeMap<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                checkTestMethod(method);
                if (!method.isAnnotationPresent(Skip.class)){
                    Test annotation = method.getAnnotation(Test.class);
                    int order = annotation.order();
                    treeMap.put(order, method);
                }
            }
        }
        treeMap.values().forEach(it -> runTest(it, target));
    }

    private static void checkTestMethod(Method method) {
        if (!method.getReturnType().isAssignableFrom(void.class) ||
                method.getParameterCount() != 0) {
            throw new IllegalArgumentException("Метод \"" + method.getName()
                    + "\" должен быть void и не иметь аргументов");
        }
    }

    private static void runTest(Method testMethod, Object testObj) {
        try {
            testMethod.invoke(testObj);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось запустить тестовый метод \"" + testMethod.getName() + "\"");
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }
}

