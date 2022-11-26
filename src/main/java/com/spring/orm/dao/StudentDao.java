package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    // Save Student
    @Transactional
    public int insert(Student student)
    {
        //Insert data into DB
        Integer i =(Integer) this.hibernateTemplate.save(student);
        return i;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
