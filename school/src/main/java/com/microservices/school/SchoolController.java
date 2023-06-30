package com.microservices.school;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {
	private final SchoolService service;

	@GetMapping
	public ResponseEntity<List<Schools>> findAllSchools() {
		return ResponseEntity.ok(service.findAllSchools());
	}

	@PostMapping
	public void saveSchool(@RequestBody Schools school) {
		service.saveSchool(school);
	}
	
	@GetMapping("/students/{school-id}")
	@CircuitBreaker(fallbackMethod =  "schoolServiceFallbackMethod",name = "schoolService")
	public ResponseEntity<?> findAllStudentsBySchoolId(@PathVariable(name ="school-id") Long schoolId ) {
		return ResponseEntity.ok(service.findAllStudentsBySchoolId(schoolId));
	}
	
	public ResponseEntity<?> schoolServiceFallbackMethod(Long schoolId, Throwable e) {
		return ResponseEntity.ok("School Service is taking longer time. Please try again later.");
	}
	
	
}
