package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetWorking {

    public static void main(String[]args){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Student student = (Student) session.get(Student.class,4);

        if(student==null)System.out.println("no student found");

        System.out.println("retreived student ::::::: "+student);

        session.close();
        sessionFactory.close();
    }
}
