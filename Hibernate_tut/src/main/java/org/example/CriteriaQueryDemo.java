package org.example;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CriteriaQueryDemo {

    public static void main( String[] args ) {

        /* --------------------  Criteria Query Example on Student table (single table)------------------  */

        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

//        Transaction tx = session.beginTransaction();

        // Obtain an instance of CriteriaBuilder from the session
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        // Create an instance of CriteriaQuery
        CriteriaQuery<Student> criteria = criteriaBuilder.createQuery(Student.class);

        /*      Sql query

        select *
        from student
        where name="Aryan"

        */

        /*


        // Define the root of the query (the FROM clause)
        Root<Student> root = criteria.from(Student.class);

        //Define the selection criteria
        criteria.select(root);

        // Define the query criteria (the WHERE clause)
        criteria.where(criteriaBuilder.equal(root.get("name"),"Aryan"));

        // Create the query
        Query<Student> query = session.createQuery(criteria);

        // Execute the query and get the result list
        List<Student> studentsList = query.getResultList();

        for(Student student:studentsList){
            System.out.println(student.toString());
        }

        */



        /*

        SELECT *
                FROM student
        WHERE name LIKE '%j%';


         */

        /*

        Root<Student> root =  criteria.from(Student.class);
        criteria.select(root);
        Predicate p1 = criteriaBuilder.like(root.get("name"),"%j%");
        criteria.where(p1);

        Query<Student> query = session.createQuery(criteria);
        List<Student> studentList = query.getResultList();

        for(Student student:studentList){
            System.out.println(student.toString());
        }

         */


        /*

        SELECT *
                FROM student
        WHERE name LIKE '%j%'
        or city = "Gurgaon";


         */

/*

        ######################  using or method


        Root<Student> root =  criteria.from(Student.class);
        criteria.select(root);
        Predicate p1 = criteriaBuilder.like(root.get("name"),"%j%");
        Predicate p2 = criteriaBuilder.equal(root.get("city"),"Gurgaon");

        Predicate combined = criteriaBuilder.or(p1,p2);
        criteria.where(combined);

        Query<Student> query = session.createQuery(criteria);
        List<Student> studentList = query.getResultList();

        for(Student student:studentList){
            System.out.println(student.toString());
        }

 */

//        ######################  using List<predicates>

        Root<Student> root =  criteria.from(Student.class);
        criteria.select(root);
        Predicate p1 = criteriaBuilder.like(root.get("name"),"%j%");
        Predicate p2 = criteriaBuilder.equal(root.get("city"),"Gurgaon");

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(p1);
        predicates.add(p2);

        Predicate combinedPredicate = criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        criteria.where(combinedPredicate);

        Query<Student> query = session.createQuery(criteria);
        List<Student> studentList = query.getResultList();

        for(Student student:studentList){
            System.out.println(student.toString());
        }

//        tx.commit();

        session.close();

        sessionFactory.close();

    }
}
