package org.example.lesson2.hw;


import org.example.lesson2.hw.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

public class MyTest {

    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    public void init() {
        System.out.println("Database load");
        for (int i = 0; i < 10; i++) {
            personRepository.people.add(new Person(i, "Name #" + i,
                    ThreadLocalRandom.current().nextInt(100)));
        }
    }

    @Test
    void testPersonRepository() {
        System.out.println("Start tests with Mock");
        if (personRepository.people != null) {
            System.out.println("People size = 10: " + (personRepository.people.size() == 10));
            System.out.println("Person get: " + personRepository.people.get(5));
            System.out.println("Person add: " +  personRepository.people.add(
                    new Person(22, "Test Person", 22)));
            System.out.println("-".repeat(40));
            personRepository.people.forEach(System.out::println);
            System.out.println("-".repeat(40));
        } else System.out.println("NULL");

    }

    @Test(order = -2)
    void firstTest() {
        System.out.println("firstTest запущен");
    }

    @Test
    @Skip
    void secondTest() {
        System.out.println("secondTest запущен");
    }

    @Test(order = 5)
    void thirdTest() {
        System.out.println("thirdTest запущен");
    }

    @AfterEach
    void runAfterEach() {
        System.out.println("End program");
    }


}
