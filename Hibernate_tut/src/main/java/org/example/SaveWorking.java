package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class SaveWorking
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

//        System.out.println(sessionFactory);
//        System.out.println(sessionFactory.isClosed());

        // entity to save
        Student student1 = new Student("Dheeraj","New Delhi");
        Student student2 = new Student("Deepak","New Delhi");
        Student student3 = new Student("Deepanshu","Faridabad");
        Student student4 = new Student("Aryan","Gurgaon");
//        student.toString();

//        System.out.println("student info ::::::    " +student3);

        // opening session
        Session session = sessionFactory.openSession();
        // creating transaction
        Transaction tx = session.beginTransaction();

        try{
            // saving the Student entity
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);
        }catch (Exception e){
            e.printStackTrace();
        }

        // committing transaction
        tx.commit();
        // closing session
        session.close();
    }


//    public static void main( String[] args ) throws IOException
//    {
//        System.out.println( "----------- ------- Saving the image   ----------- -------" );
//
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory sessionFactory = cfg.buildSessionFactory();
//
//        FileInputStream file = new FileInputStream("src/main/resources/address_image.png");
//        System.out.println("available file length " +file.available());
//        byte [] image =  new byte[file.available()];
//        file.read(image);
//
//
//        // entity to save
//        StudentAdress studentAdress = new StudentAdress();
//        studentAdress.setState("Delhi");
//        studentAdress.setCity("New Delhi");
//        studentAdress.setAddedDate(new Date());
//        studentAdress.setStreet("Sangam Vihar");
//        studentAdress.setPinCode("110062");
//        studentAdress.setAddressImage(image);
//
//        System.out.println("student address info ::::::    " +studentAdress.toString());
//
//        // opening session
//        Session session = sessionFactory.openSession();
//        // creating transaction
//        Transaction tx = session.beginTransaction();
//
//        try{
//            // saving the studentAddress entity
//            session.save(studentAdress);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        // committing transaction
//        tx.commit();
//        // closing session
//        session.close();
//    }


}
