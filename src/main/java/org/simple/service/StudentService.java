package org.simple.service;

import org.simple.maven_sample.Student;
import org.simple.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// Save a new student
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	// Retrieve all students
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	// Update an existing school
	public Student updateStudent(Long id, Student studentDetails) {
		Optional<Student> optionalStudent = studentRepository.findById(studentDetails.getId());
		if (optionalStudent.isPresent()) {
			Student existingStudent = optionalStudent.get();
			existingStudent.setName(studentDetails.getName()); // Update student name
			existingStudent.setAge(studentDetails.getAge()); // Update student age
			existingStudent.setOrgid(studentDetails.getOrgid()); // Update student orgid
			return studentRepository.save(existingStudent);
		} else {
			throw new RuntimeException("Student not found with id " + id);
		}
	}
}
