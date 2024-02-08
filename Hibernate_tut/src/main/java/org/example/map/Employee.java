package org.example.map;

import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private int employeeId;
    @Column(name = "emp_name")
    private String employeeName;
    @ManyToOne
    @JoinColumn(name = "emp_dep")
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

    public Department getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Department employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
}
