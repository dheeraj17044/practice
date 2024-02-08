package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ObjectStatesDemo {

    public static void main( String[] args )
    {

        /* --------------------  Hibernate's object state lifecycle ------------------  */

        System.out.println( "Hello World!" );

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Student student = new Student();
        student.setName("Disha");
        student.setCity("Chandigarh");
        student.setRollNumber(5);
        // Transient state: - not associated with session + not in DB

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(student);
        // Persistent state: - associated with session + present in DB
        student.setCity("Gurgaon");

        tx.commit();

        session.close();
//
//        student.setCity("Delhi");
//        // Detached state: - not associated with session + present in DB
//
//        session = sessionFactory.openSession();
//
//        tx = session.beginTransaction();
//
//        session.update(student);
//        // Detached state ----> Persistent state
//
//        tx.commit();
//
//        session.close();


        /* --------------------- removed state explained ------------------------


        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student s = (Student) session.get(Student.class,5);
        // Persistent state
        session.delete(s);
        // Removed State --> associated with session + not present in DB
        tx.commit();
        session.close();


         */




        /* --------------------- update operation explained ------------------------

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        Student s = (Student) session.get(Student.class,5);
        // Persistent state
        System.out.println("fetched student from Db :::::  "+s.toString());
        s.setCity("Kerala");
        // synchronized operation
        tx.commit();
        session.close();

         */

    }
}
