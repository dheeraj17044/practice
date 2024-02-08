package org.example.map;

import javax.persistence.*;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department {

    @Id
    @Column(name = "dept_id")
    private int departmentId;

    @Column(name = "dept_name")
    private String departmentName;

    @OneToMany(mappedBy = "employeeDepartment",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Employee> employeeList;     // FetchType.EAGER --> on the spot List<Employee> fetch karke le aayega
                                            // FetchType.LAZY --> jarurat padne/get() call karne par List<Employee> fetch karke le aayega
                                            // CascadeType.ALL --> har tarike ka cascade apply ho gya related entity par (Employee)


    public Department() {
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

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
