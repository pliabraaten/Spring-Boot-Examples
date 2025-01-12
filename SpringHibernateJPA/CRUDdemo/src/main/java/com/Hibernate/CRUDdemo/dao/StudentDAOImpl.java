package com.Hibernate.CRUDdemo.dao;

import com.Hibernate.CRUDdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;


@Repository  // Supports component scanning and translates exceptions
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional  // Since update to database
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);  // Student.class is entity class; id is primary key
    }

    // implement query
    @Override
    public List<Student> findAll() {

        // create query and sort by lastName entity
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName asc", Student.class);
                                                    // Student is JPA entity class name, not db table
        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                            "FROM Student WHERE lastName=:theData", Student.class);
                            // JPQL named parameters (theData) are prefixed with :
        // set query parameters
        theQuery.setParameter("theData", theLastName);  // set theData as theLastName value that was passed in

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional  // needed to perform update to db
    public void update(Student theStudent) {

        entityManager.merge(theStudent); // updates the student record in db with data from theStudent instance
    }

    @Override
    @Transactional  // needed to perform update to db
    public void delete(Integer id) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);  // find student based on passed in id
        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional  // needed to perform update to db
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();  // execute statement
        return numRowsDeleted;
    }
}
