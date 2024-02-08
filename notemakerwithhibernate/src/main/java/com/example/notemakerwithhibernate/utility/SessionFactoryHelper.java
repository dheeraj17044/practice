package com.example.notemakerwithhibernate.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryHelper {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sessionFactory = cfg.buildSessionFactory();
        }
        return sessionFactory;
    }
}
