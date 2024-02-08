package com.example.demo.nativequerytut.entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int departmentId;

    @Column(name = "dept_name")
    private String departmentName;

    @OneToMany(mappedBy = "employeeDepartment")
    private List<Employee> employees;

    public Department() {
    }

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}


//CREATE TABLE `department` (
//        `dept_id` INT NOT NULL AUTO_INCREMENT,
//  `dept_name` VARCHAR(255) NOT NULL,
//PRIMARY KEY (`dept_id`)
//);

