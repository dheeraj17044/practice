package org.example.map;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetOneToOne {
    public static void main(String[]args){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        /*
        Question question1 = (Question) session.get(Question.class,101);

        if(question1!=null){
            System.out.println("retrieved question ::::::: "+question1.getQuestionText());
            Answer answer1 = question1.getAnswer();
            System.out.println("retrieved question ::::::: "+answer1.getAnswerText());
        }

         */

        Answer answer2 = (Answer) session.get(Answer.class,202);

        if(answer2!=null) {
            System.out.println("retrieved answer ::::::: " + answer2.getAnswerText());
            Question question = answer2.getQuestion();
            System.out.println("retrieved question ::::::: " + question.getQuestionText());
        }

        session.close();
        sessionFactory.close();
    }
}
