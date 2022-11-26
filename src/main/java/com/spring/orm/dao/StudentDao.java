package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    // Save Student
    public int insert(Student student)
    {
        //Insert data into DB
        Integer i =(Integer) this.hibernateTemplate.save(student);
        return i;
    }
}
