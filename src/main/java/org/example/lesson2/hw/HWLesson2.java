package org.example.lesson2.hw;

import org.example.lesson2.hw.processors.AfterEachAnnotationProcessor;
import org.example.lesson2.hw.processors.BeforeEachAnnotationProcessor;
import org.example.lesson2.hw.processors.MockAnnotationProcessor;
import org.example.lesson2.hw.processors.TestAnnotationProcessor;

/**
 * Расширить пример с запуском тестов следующими фичами:
 * 1. Добавить аннотации BeforeEach, AfterEach,
 * которые ставятся над методами void без аругментов и запускаются ДО и ПОСЛЕ всех тестов соответственно.
 * 2. В аннотацию Test добавить параметр order() со значением 0 по умолчанию.
 * Необходимо при запуске тестов фильтровать тесты по этому параметру (от меньшего к большему).
 * Т.е. если есть методы @Test(order = -2) void first, @Test void second, Test(order = 5) void third,
 * то порядок вызовов first -> second -> third
 * 3.* Добавить аннотацию @Skip, которую можно ставить над тест-методами. Если она стоит - то тест не запускается.
 * 4.* При наличии идей, реализовать их и написать об этом в комментарии при сдаче.
 */

public class HWLesson2 {
    public static void main(String[] args) throws Exception {
        MyTest testInstance = new MyTest();
        MockAnnotationProcessor.process(testInstance);
        BeforeEachAnnotationProcessor.process(testInstance);
        TestAnnotationProcessor.process(testInstance);
        AfterEachAnnotationProcessor.process(testInstance);
    }


}
