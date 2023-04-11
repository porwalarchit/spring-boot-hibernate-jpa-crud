package com.archit.cruddemo;

import com.archit.cruddemo.dao.StudentDao;
import com.archit.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
//			createStudent(studentDao);

//			readStudent(studentDao);

//			queryForStudents(studentDao);

//			queryForStudentsByLastName(studentDao);

//			updateStudent(studentDao);

//			deleteStudent(studentDao);

//			deleteAllStudents(studentDao);

			createMultipleStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDao.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDao.findById(studentId);

		// change first name to "Paul"
		System.out.println("Updating Student...");
		myStudent.setFirstName("Paul");

		// update the student
		studentDao.update(myStudent);

		// display the updated student
		System.out.println("Updated Student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		// get a list of students
		List<Student> theStudents = studentDao.findByLastName("Duck");

		// display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		// get a list of students
		List<Student> theStudents = studentDao.findAll();

		// display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDao studentDao) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		// save the student
		System.out.println("Saving the student...");
		studentDao.save(tempStudent);

		// display id od the save student
		int id = tempStudent.getId();
		System.out.println("Saved Student. Generated id: " + id);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: : " + id);
		Student myStudent = studentDao.findById(id);

		// display student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDao studentDao) {
		// create multiple students
		System.out.println("Creating 3 Student objects...");
		Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@gmail.com");

		// save the student objects
		System.out.println("Saving the students...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

	}

	private void createStudent(StudentDao studentDao) {

		// create the student object
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("Paul", "Doe", "pauldoe@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDao.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}
}
