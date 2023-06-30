package com.microservices.student;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService service;

	@GetMapping
	public ResponseEntity<List<Students>> findAllStudents() {
		return ResponseEntity.ok(service.findAllStudents());
	}

	@PostMapping
	public void saveSchool(@RequestBody Students student) {
		service.saveStudent(student);
	}
	
	@GetMapping("/{school-id}")
	public ResponseEntity<List<Students>> findAllStudentsBySchoolId(@PathVariable("school-id") Long schoolId) {
		return ResponseEntity.ok(service.findAllStudentsBySchoolId(schoolId));
	}
}
