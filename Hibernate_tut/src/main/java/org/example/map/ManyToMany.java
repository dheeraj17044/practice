package org.example.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToMany {

    public static void main(String []args) {

        /* ------ ManyToMany Mapping between User and Pharmacy--------- */

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Pharmacy p1 = new Pharmacy();
        p1.setPharmacyId(101);
        p1.setPharmacyName("P1");

        Pharmacy p2 = new Pharmacy();
        p2.setPharmacyId(102);
        p2.setPharmacyName("P2");

        Pharmacy p3 = new Pharmacy();
        p3.setPharmacyId(103);
        p3.setPharmacyName("P3");

        List<Pharmacy> pharmacyList1 = new ArrayList<>();
        pharmacyList1.add(p1);
        pharmacyList1.add(p2);
        pharmacyList1.add(p3);

        List<Pharmacy> pharmacyList2 = new ArrayList<>();
        pharmacyList2.add(p1);
        pharmacyList2.add(p2);

        User u1 = new User();
        u1.setUserId(1);
        u1.setUserName("Dheeraj");
        u1.setPharmacies(pharmacyList1);

        User u2 = new User();
        u2.setUserId(2);
        u2.setUserName("Deepak");
        u2.setPharmacies(pharmacyList2);

        List<User> userList1 = new ArrayList<>();
        userList1.add(u1);
        userList1.add(u2);
        p1.setUsers(userList1);

        p2.setUsers(userList1);

        List<User> userList2 = new ArrayList<>();
        userList1.add(u1);
        p3.setUsers(userList2);


        Transaction tx = session.beginTransaction();

        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(u1);
        session.save(u2);

        tx.commit();


        session.close();
        sessionFactory.close();

    }
}
