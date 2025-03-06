package org.simple.controller;

import java.util.List;
import java.util.Optional;

import org.simple.maven_sample.School;
import org.simple.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Base URL for all endpoints in this controller
public class SchoolController {

	@Autowired
	private SchoolService schoolservice;

	// POST: /api/createSchool
	@PostMapping("/createSchool")
	public School createSchool(@RequestBody School school) {
		return schoolservice.saveSchool(school);
	}

	// GET: /api/schools
	@GetMapping("/schools")
	public List<School> getAllSchools() {
		return schoolservice.getAllSchools();
	}

	// GET: /api/schools/{id} → Get a school by ID
	@GetMapping("/schools/{id}")
	public Optional<School> getSchoolById(@PathVariable Long id) {
		return schoolservice.getSchoolById(id);
	}

	 // PUT: /api/updateSchool/{id} → Update a school by ID
    @PutMapping("/updateSchool/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
        return schoolservice.updateSchool(id, school);
    }
}
