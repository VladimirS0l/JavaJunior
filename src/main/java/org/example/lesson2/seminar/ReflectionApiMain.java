package org.example.lesson2.seminar;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionApiMain {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass
                .getConstructor(String.class, Integer.class, Double.class);
        Person person = constructor.newInstance("Name", 21, 1232.1);
        System.out.println(person);

        Constructor<Person> constructor1 = personClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person person1 = constructor1.newInstance("Private constructor");
        System.out.println(person1);

        //ERROR, need setAccessible
//        constructor1 = personClass.getDeclaredConstructor(String.class);
//        Person person2 = constructor1.newInstance("Private constructor, no access");
//        System.out.println(person2);

        Class<Head> headClass = Head.class;
        Class<? super Head> superclass = headClass.getSuperclass();

        System.out.println(personClass == superclass);

        Constructor<? super Head> declaredConstructor = superclass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Object object = declaredConstructor.newInstance("Head constructor");
        System.out.println(object);

        Field field = Person.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person, "Rename");
        System.out.println(person);

        Method method = Person.class.getMethod("toString");
        System.out.println(method.invoke(person));

        Method setSalary = Person.class.getMethod("setSalary", Double.class);
        setSalary.invoke(person, 333.3);
        System.out.println(person);

//        person = Person.randomPerson();
//        System.out.println(person);
        Method randomPerson = Person.class.getMethod("randomPerson");
        Object invoke = randomPerson.invoke(null);
        System.out.println(invoke);


    }
}
