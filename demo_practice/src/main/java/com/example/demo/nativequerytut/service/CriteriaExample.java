package com.example.demo.nativequerytut.service;

import com.example.demo.nativequerytut.entity.Department;
import com.example.demo.nativequerytut.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.JoinType;
import java.util.List;

public class CriteriaExample {

    public static void main(String[]args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

//        Q) retrieve the employee details who work in the department

/*

        * sql query


        select e.name as emp_name, d.name as dept_name
        from employee as e
        join department as d
        on e.dept_id = d.id


        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);

        Root<Employee> employee = criteria.from(Employee.class);

        Join<Employee, Department> department = employee.join("employeeDepartment");

        criteria.multiselect(
                employee.get("employeeName"),
                department.get("departmentName"));

 */



//        Q) Get all departments with their employee count

/*

        * sql query


        SELECT d.name, COUNT(e.id) as employee_count
        FROM department d
        LEFT JOIN employee e ON d.id = e.department_id
        GROUP BY d.id;


        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);

        Root<Department> department = criteria.from(Department.class);

        Join<Department,Employee> employee = department.join("employees",JoinType.LEFT);
        criteria.groupBy(department.get("departmentId"));

        criteria.multiselect(
                department.get("departmentName"),
                criteriaBuilder.count(employee.get("employeeId"))
        );

        Query<Object[]> query = session.createQuery(criteria);

        List<Object[]> result = query.getResultList();

 */


//        Q) Find Departments Without Any Employees

/*
        sql query: -

                select d.id, d.name
        from department d
        left join employee e on d.id = e.dept_id
        where e.id is null;


        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);

        Root<Department> department = criteria.from(Department.class);

        Join<Department,Employee> employee = department.join("employees",JoinType.LEFT);

        criteria.where(criteriaBuilder.isNull(employee.get("employeeId")));

        criteria.multiselect(
                department.get("departmentId"),
                department.get("departmentName")
        );

        Query<Object[]> query = session.createQuery(criteria);

        List<Object[]> result = query.getResultList();


 */


//        Q) List Departments Sorted by the Number of Employees

    /*
        sql query: -

        SELECT d.name, COUNT(e.id) as employee_count
        FROM department d
        LEFT JOIN employee e ON d.id = e.department_id
        GROUP BY d.id
        order by employee_count;


        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);

        Root<Department> department = criteria.from(Department.class);

        Join<Department,Employee> employee = department.join("employees",JoinType.LEFT);

        criteria.groupBy(department.get("departmentId"));
        criteria.orderBy(criteriaBuilder.desc(criteriaBuilder.count(employee.get("employeeId"))));

        criteria.multiselect(
                department.get("departmentName"),
                criteriaBuilder.count(employee.get("employeeId"))
        );

        Query<Object[]> query = session.createQuery(criteria);

        List<Object[]> result = query.getResultList();

     */


//        Q) Find the Highest Earning Employee in Each Department

/*
        sql query: -

        SELECT d.name AS department_name, MAX(e.salary) AS max_salary
        FROM department d
        JOIN employee e ON d.id = e.department_id
        GROUP BY d.id;

*/

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);

        Root<Department> department = criteria.from(Department.class);

        Join<Department,Employee> employee = department.join("employees");

        criteria.groupBy(department.get("departmentId"));

        criteria.multiselect(
                department.get("departmentName"),
                criteriaBuilder.max(employee.get("salary"))
        );

        Query<Object[]> query = session.createQuery(criteria);

        List<Object[]> result = query.getResultList();

        System.out.println();
        System.out.println();

        for(Object[] obj : result){
            System.out.println(obj[0]);
            System.out.println(obj[1]);

            System.out.println();
        }











        session.close();

        sessionFactory.close();
    }
}
