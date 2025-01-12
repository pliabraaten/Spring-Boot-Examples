package com.Hibernate.CRUDdemo.dao;

import com.Hibernate.CRUDdemo.entity.Student;
import java.util.List;

// DAO methods
public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();  // returns int for number deleted
}
