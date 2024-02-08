package com.example.demo.nativequerytut.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class NativeExample {

    public static void main( String[] args ) {

        /* --------------------  Native Query Example with Department and Employee tables ------------------  */

        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        System.out.println();
        System.out.println();

        /* ---- Retrieve employees along with their department information --------------- */
//        String sqlQuery = "SELECT emp.emp_id, emp.emp_name, emp.designation, emp.salary, dept.dept_name\n" +
//                "FROM employee emp\n" +
//                "JOIN department dept ON emp.dept_id = dept.dept_id";


        /* ---- Retrieve employees earning more than a specific salary --------------- */
//        String sqlQuery = "SELECT * FROM employee WHERE salary > 80000";


        /* ---- Count the number of employees in each department --------------- */
//        String sqlQuery = " SELECT dept.dept_name, COUNT(emp.emp_id) AS num_employees\n" +
//                "        FROM department dept\n" +
//                "        LEFT JOIN employee emp ON dept.dept_id = emp.dept_id\n" +
//                "        GROUP BY dept.dept_name";


        /* ---- Calculate the average salary of employees in each department --------------- */
        String sqlQuery = "SELECT dept.dept_name, AVG(emp.salary) AS avg_salary\n" +
                "FROM department dept\n" +
                "LEFT JOIN employee emp ON dept.dept_id = emp.dept_id\n" +
                "GROUP BY dept.dept_name";

        NativeQuery nativeQuery  = session.createNativeQuery(sqlQuery);

        List<Object[]> objects = nativeQuery.list();
        for(Object[] obj:objects){
            System.out.println(Arrays.deepToString(obj));
        }

        System.out.println();
        System.out.println();

        tx.commit();

        session.close();

        sessionFactory.close();
    }
}
