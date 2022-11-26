package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {
    @Id
    @Column(name = "id")
    private int studentId;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public Student() {
    }

    public Student(int studentId, String name, String city) {
        this.studentId = studentId;
        this.name = name;
        this.city = city;
    }
}
