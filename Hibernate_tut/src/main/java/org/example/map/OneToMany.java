package org.example.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToMany {

    public static void main(String[]args) {

        /* ------ OneToMany and ManyToOne Mapping between Department and Employee --------- */

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

/*

        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setEmployeeName("Dheeraj");
//        employee1.setEmployeeDepartment(101);

        Employee employee2 = new Employee();
        employee2.setEmployeeId(2);
        employee2.setEmployeeName("Deepak");
//        employee2.setEmployeeDepartment(101);

        Employee employee3 = new Employee();
        employee3.setEmployeeId(3);
        employee3.setEmployeeName("Deepanshu");
//        employee3.setEmployeeDepartment(101);

        Employee employee4 = new Employee();
        employee4.setEmployeeId(4);
        employee4.setEmployeeName("Aryan");
//        employee4.setEmployeeDepartment(102);



        List<Employee> employeeListDept1 = new ArrayList<>();
        employeeListDept1.add(employee1);
        employeeListDept1.add(employee2);
        employeeListDept1.add(employee3);

        Department department1 = new Department();
        department1.setDepartmentId(101);
        department1.setDepartmentName("HR");
        department1.setEmployeeList(employeeListDept1);


        employee1.setEmployeeDepartment(department1);
        employee2.setEmployeeDepartment(department1);
        employee3.setEmployeeDepartment(department1);




        List<Employee> employeeListDept2 = new ArrayList<>();
        employeeListDept2.add(employee4);

        Department department2 = new Department();
        department2.setDepartmentId(102);
        department2.setDepartmentName("IT");
        department2.setEmployeeList(employeeListDept2);


        employee4.setEmployeeDepartment(department2);
*/

        Employee employee1 = new Employee();
        employee1.setEmployeeId(10);
        employee1.setEmployeeName("Gaurav");
//        employee1.setEmployeeDepartment(101);

        Employee employee2 = new Employee();
        employee2.setEmployeeId(11);
        employee2.setEmployeeName("Suman");
//        employee2.setEmployeeDepartment(101);


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        Department department = new Department();
        department.setDepartmentId(103);
        department.setDepartmentName("FIN");
        department.setEmployeeList(employeeList);

        employee1.setEmployeeDepartment(department);
        employee2.setEmployeeDepartment(department);


        // opening session
        Session session = sessionFactory.openSession();
        // creating transaction
        Transaction tx = session.beginTransaction();

        try{
            // saving the entity

            // saving the department only --> employees will be saved automatically due to CascadeType.ALL
            session.save(department);


/*            session.save(employee1);
            session.save(employee2);
            session.save(employee3);
            session.save(employee4);
            session.save(department1);
            session.save(department2);

 */

        }catch (Exception e){
            e.printStackTrace();
        }

        // committing transaction
        tx.commit();
        // closing session
        session.close();
    }
}
