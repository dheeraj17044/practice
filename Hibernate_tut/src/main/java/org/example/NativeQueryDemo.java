package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class NativeQueryDemo {

    public static void main( String[] args ) {

        /* --------------------  Native Query Example ------------------  */

        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        /* ---- fetch all students --------------- */
//        String sqlQuery = "select * from student";

        /* ---- fetch students who lives in gurgaon --------------- */
//        String sqlQuery = "select * from student where city='Gurgaon'";

        /* ---- fetch student whose roll number is even number --------------- */
//        String sqlQuery = "SELECT * FROM student WHERE rollNumber % 2 = 0";

        /* ---- fetch Students with Roll Numbers Between 2 and 5 --------------- */
        String sqlQuery = "SELECT * FROM student WHERE rollNumber between 2 and 5";

        NativeQuery nativeQuery  = session.createSQLQuery(sqlQuery);

        List<Object[]> objects = nativeQuery.list();

        List<Student> studentsList = new ArrayList<>();

        for(Object[] obj:objects){
            Student s = new Student((Integer) obj[0], (String) obj[1], (String) obj[2]);
            studentsList.add(s);
            System.out.println(s);
        }

        System.out.println("number of students: - "+studentsList.size());

        tx.commit();

        session.close();

        sessionFactory.close();
    }
}
