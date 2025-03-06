package org.simple.repository;

import org.simple.maven_sample.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
	 boolean existsById(Long id); // Method to check if school ID exists
}
