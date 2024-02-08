package org.example.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetOneToMany {

    public static void main(String[]args){

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Department d1 = (Department) session.get(Department.class,101);

        System.out.println("Department id: - "+d1.getDepartmentId());
        System.out.println("Department name: - " + d1.getDepartmentName());
//        System.out.println(d1.getEmployeeList().size());

//        for(Employee employee: d1.getEmployeeList()){
//            System.out.println(employee.getEmployeeId());
//            System.out.println(employee.getEmployeeName());
//            System.out.println(employee.getEmployeeDepartment().getDepartmentId());
//
//            System.out.println();
//            System.out.println();
//        }

        session.close();
        sessionFactory.close();
    }
}
