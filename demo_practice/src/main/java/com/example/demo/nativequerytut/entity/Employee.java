package com.example.demo.nativequerytut.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.math.BigDecimal;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int employeeId;

    @Column(name = "emp_name")
    private String employeeName;

    private String designation;

    @Column(precision = 10, scale = 2)
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department employeeDepartment;

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Department getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Department employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
}


//CREATE TABLE `employee` (
//        `emp_id` INT NOT NULL AUTO_INCREMENT,
//  `emp_name` VARCHAR(255) NOT NULL,
//  `designation` VARCHAR(255) NOT NULL,
//  `salary` DECIMAL(10, 2) NOT NULL,
//  `dept_id` INT,
//PRIMARY KEY (`emp_id`),
//FOREIGN KEY (`dept_id`) REFERENCES `department`(`dept_id`)
//        );

