package org.example.lesson4.hw;

import org.example.lesson4.hw.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TaskFourJpa {
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public Car saveCar(Car car) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(car);
        session.getTransaction().commit();
        session.close();
        return car;
    }
}
