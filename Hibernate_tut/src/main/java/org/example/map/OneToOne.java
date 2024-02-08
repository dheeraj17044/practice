package org.example.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {

    public static void main(String[]args){

        /* ------ One to One Mapping between Question and Answer --------- */


        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();


        Answer answer1 = new Answer();
        answer1.setAnswerId(201);
        answer1.setAnswerText("Java is a programming language");


        Question question1 = new Question();
        question1.setQuestionId(101);
        question1.setQuestionText("What is Java?");
        question1.setAnswer(answer1);

        answer1.setQuestion(question1);


        Answer answer2 = new Answer();
        answer2.setAnswerId(202);
        answer2.setAnswerText("Intellij is the IDE");


        Question question2 = new Question();
        question2.setQuestionId(102);
        question2.setQuestionText("What is Intellij?");
        question2.setAnswer(answer2);

        answer2.setQuestion(question2);


        // opening session
        Session session = sessionFactory.openSession();
        // creating transaction
        Transaction tx = session.beginTransaction();

        try{
            // saving the entity
//            session.save(question1);
//            session.save(answer1);
            session.save(question2);
//            session.save(answer2);

        }catch (Exception e){
            e.printStackTrace();
        }

        // committing transaction
        tx.commit();
        // closing session
        session.close();
    }
}
