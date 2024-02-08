package org.example.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hello {

    public static void main(String[]args) {

        /* ------ OneToMany and ManyToOne Mapping between Department and Employee --------- */

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // opening session
        Session session = sessionFactory.openSession();

        Department department = (Department) session.get(Department.class,103);

        Employee e1 = (Employee) session.get(Employee.class,10);
        e1.setEmployeeDepartment(department);
        Employee e2 = (Employee) session.get(Employee.class,11);
        e2.setEmployeeDepartment(department);
        // creating transaction
        Transaction tx = session.beginTransaction();

        try{
            // saving the entity

//            session.save(e1);
//            session.save(e2);

            // testing cascading delete functionality

            session.delete(department);

        }catch (Exception e){
            e.printStackTrace();
        }

        // committing transaction
        tx.commit();
        // closing session
        session.close();
    }
}
