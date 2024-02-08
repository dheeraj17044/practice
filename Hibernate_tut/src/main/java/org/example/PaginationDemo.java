package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class PaginationDemo {

    public static void main(String[]args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        String sqlQuery = "select * from student";

        NativeQuery nativeQuery  = session.createSQLQuery(sqlQuery);

        nativeQuery.setFirstResult(1);
        nativeQuery.setMaxResults(3);

        List<Object[]> objects = nativeQuery.list();

        List<Student> studentsList = new ArrayList<>();

        System.out.println();
        System.out.println();

        for(Object[] obj:objects){
            Student s = new Student((Integer) obj[0], (String) obj[1], (String) obj[2]);
            studentsList.add(s);
            System.out.println(s);
        }

        System.out.println("number of students: - "+studentsList.size());

        session.close();
        sessionFactory.close();

    }
}
