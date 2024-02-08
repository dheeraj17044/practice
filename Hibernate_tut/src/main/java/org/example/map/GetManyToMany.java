package org.example.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetManyToMany {

    public static void main(String[]args){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        User u1 = (User) session.get(User.class,1);

        System.out.println("user  "+u1);

        for(Pharmacy pharmacy: u1.getPharmacies()){
            System.out.println(pharmacy.getPharmacyId());
            System.out.println(pharmacy.getPharmacyName());
            System.out.println(pharmacy.getUsers().size());

            System.out.println();
            System.out.println();
        }

        session.close();
        sessionFactory.close();
    }
}
