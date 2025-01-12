package com.Hibernate.CRUDdemo;

import com.Hibernate.CRUDdemo.dao.StudentDAO;
import com.Hibernate.CRUDdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruDdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruDdemoApplication.class, args);
	}


	//	CommandLineRunner is a simple Spring Boot interface with a run method.
	//	Spring Boot will automatically call the run method of all beans implementing
		//	this interface after the application context has been loaded.
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {  // Inject studentDAO

		return runner -> {
//			createsStudent(studentDAO);

			createsMultipleStudents(studentDAO);

//			readStudent(studentDAO);
			
//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		// retrieve student based on id: primary key
		int studentID = 3;
		System.out.println("Deleting student with id: " + studentID);

		// remove the student
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);  // assigns existing student instance in db to myStudent var

		// change first name to "Jim"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Jim");  // uses setter method on this to set the name of this student instance

		// update the student
		studentDAO.update(myStudent);  // updates db record by synchronizing db record with student instance

		// display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Ringo");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	// Query list of students using JPQL
	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of student
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {  // Loop through list of students
			System.out.println(tempStudent);  // Print out each student
		}
	}

	// Create, save, and then retrieve student from db
	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student ...");
		Student tempStudent = new Student("Ringo", "Beatle", "ringo@gmail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student info with id: " + theId);
		Student myStudent = studentDAO.findById(theId);  // Create student object of this student to use later
		studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	// Create and save multiple students to the db
	private void createsMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 4 new student object ...");
		Student tempStudent1 = new Student("Paul", "Doe", "paul@gmail.com");
		Student tempStudent2 = new Student("John", "Public", "john@gmail.com");
		Student tempStudent3 = new Student("George", "Ringo", "george@gmail.com");
		Student tempStudent4 = new Student("Ringo", "Star", "ringo@gmail.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
	}

	private void createsStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
