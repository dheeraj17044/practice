package com.example.notemakerwithhibernate.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHelper {

    private static Session session;

    public static Session getSession() {
        if(session==null || !session.isOpen()){
            SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory();
            session = sessionFactory.openSession();
        }
        return session;
    }
}