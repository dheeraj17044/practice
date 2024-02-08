//package org.example.map;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MapDemo {
//
//    public static void main(String []args){
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory sessionFactory = cfg.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
////        Answer answer1 = new Answer();
////        answer1.setAnswerId(101);
////        answer1.setText("Java is programming Language");
////
////        Question question1 = new Question();
////        question1.setQuestionId(1);
////        question1.setText("What is Java?");
////        question1.setAnswerId(answer1);
//
//        Question question1 = new Question();
//        question1.setQuestionId(1);
//        question1.setText("What is java?");
//
//        Answer answer1 = new Answer();
//        answer1.setAnswerId(101);
//        answer1.setText("Java is Programming Language");
////        answer1.setQuestion(question1);
//
//
//        Answer answer2 = new Answer();
//        answer2.setAnswerId(102);
//        answer2.setText("Java can do anything");
////        answer2.setQuestion(question1);
//
//        Answer answer3 = new Answer();
//        answer3.setAnswerId(103);
//        answer3.setText("Java has multiple frameworks");
////        answer3.setQuestion(question1);
//
//        List<Answer> list = new ArrayList<>();
//        list.add(answer1);
//        list.add(answer2);
//        list.add(answer3);
//
//
//        question1.setAnswerId(list);
//
//        Transaction transaction = session.beginTransaction();
//
//        session.save(answer1);
//        session.save(answer2);
//        session.save(answer3);
//        session.save(question1);
//
//
//        transaction.commit();
//
//        Question getQuestion = (Question) session.get(Question.class,1);
//        List<Answer> ans = getQuestion.getAnswerId();
//
//        System.out.println("retreived question :::::: "+getQuestion);
//        System.out.println("retreived answers list size :::::: "+ans.size());
//
//        for(Answer a:ans){
//            System.out.println("retreived answer :::::: "+a.getText());
//        }
//
//
//
//        session.close();
//        sessionFactory.close();
//    }
//}
