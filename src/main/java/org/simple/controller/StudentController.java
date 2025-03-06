package org.simple.controller;

import org.simple.service.StudentService;
import org.simple.maven_sample.School;
import org.simple.maven_sample.Student;
import org.simple.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students") // ✅ This is correct
public class StudentController {

	@Autowired
	private final StudentService studentService;
	private final SchoolRepository schoolRepository;

	public StudentController(StudentService studentService, SchoolRepository schoolRepository) {
		this.studentService = studentService;
		this.schoolRepository = schoolRepository;
	}

	@PostMapping
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		if (student.getOrgid() == null) {
			return ResponseEntity.badRequest().body("Org ID is required!");
		}

		// ✅ Check if the orgid exists in the school table
		boolean schoolExists = schoolRepository.existsById(student.getOrgid());
		if (!schoolExists) {
			return ResponseEntity.badRequest().body("Invalid Org ID! No matching school found.");
		}

		// ✅ Save student if orgid is valid
		Student savedStudent = studentService.saveStudent(student);
		return ResponseEntity.ok(savedStudent);
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	// PUT: /api/update/{id} → Update a student by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		// Check if request payload has an ID
		if (student.getId() == null) {
			return ResponseEntity.badRequest().body("ID is required in the request payload!");
		}
		// Call service to update student
		Student updatedStudent = studentService.updateStudent(id, student);
		return ResponseEntity.ok(updatedStudent);
	}
}
