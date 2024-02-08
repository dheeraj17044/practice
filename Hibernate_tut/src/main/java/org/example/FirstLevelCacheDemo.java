package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheDemo {

    public static void main(String[]args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();
        // by default 1st level cache enabled hoti hai, aur ye session object se associated rehti hai...

        Student student1 = session.get(Student.class,1);
        System.out.println(student1);

        System.out.println();
        System.out.println();

        // student with id=1, pehle se hi session cache mein present hai, toh db query fire nahi hogi...
        Student student2 = session.get(Student.class,1);
        System.out.println(student2);

        session.close();
        // agar session close ho gya toh session cache se bhi data remove ho jayega...

        session = sessionFactory.openSession();

        System.out.println();
        System.out.println();

        // student with id=1, ab session cache ke pas available nahi hai toh db query fire hogi...
        Student student3 = session.get(Student.class,1);
        System.out.println(student3);

        session.close();
        sessionFactory.close();

    }
}
