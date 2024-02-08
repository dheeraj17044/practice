package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCacheDemo {

    public static void main(String[]args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        // student with id=1, sessionFactory cache ke pas available nahi hai toh db query fire hogi...
        Student student1 = session.get(Student.class,1);
        System.out.println(student1);

        System.out.println();
        System.out.println();

        session.close();

        session = sessionFactory.openSession();

        System.out.println();
        System.out.println();

        // student with id=1, ab sessionFactory cache ke pas available hai toh db query fire nhi hogi...
        Student student3 = session.get(Student.class,1);
        System.out.println(student3);

        session.close();
        sessionFactory.close();

    }
}
