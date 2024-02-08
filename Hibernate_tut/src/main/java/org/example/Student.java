package org.example;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Cacheable;
import javax.persistence.Id;

@Entity
@Table(name = "student")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNumber;
    private String name;
    private String city;

    public Student() {
    }

    public Student(int rollNumber, String name, String city) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.city = city;
    }

    public Student(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
