package org.simple.service;

import org.simple.maven_sample.School;
import org.simple.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository SchoolRepository;

	// Save a new student
	public School saveSchool(School school) {
		return SchoolRepository.save(school);
	}

	public List<School> getAllSchools() {
		return SchoolRepository.findAll();
	}

	// Get a school by ID
	public Optional<School> getSchoolById(Long id) {
		return SchoolRepository.findById(id);
	}

	// Update an existing school
	public School updateSchool(Long id, School schoolDetails) {
		Optional<School> optionalSchool = SchoolRepository.findById(id);
		if (optionalSchool.isPresent()) {
			School existingSchool = optionalSchool.get();
			existingSchool.setName(schoolDetails.getName()); // Update school name
			existingSchool.setCode(schoolDetails.getCode()); // Update school code
			existingSchool.setLocation(schoolDetails.getLocation()); // Update school location
			existingSchool.setState(schoolDetails.getState()); // Update school state
			existingSchool.setCountry(schoolDetails.getCountry()); // Update school country
			return SchoolRepository.save(existingSchool);
		} else {
			throw new RuntimeException("School not found with id " + id);
		}
	}
}
