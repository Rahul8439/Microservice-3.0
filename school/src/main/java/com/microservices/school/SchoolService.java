package com.microservices.school;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {

	private final SchoolRepository repository;
	private final StudentClient studentClient;

	public void saveSchool(Schools school) {
		repository.save(school);
	}
	
	public List<Schools> findAllSchools(){
		return repository.findAll();
	}

	public SchoolStudentsResponse findAllStudentsBySchoolId(Long schoolId) {
		Schools schools = repository.findById(schoolId).get();
		List<Students> findAllStudentsBySchoolId = studentClient.findAllStudentsBySchoolId(schoolId);
		SchoolStudentsResponse build = SchoolStudentsResponse.builder().schoolName(schools.getName()).student(findAllStudentsBySchoolId)
				.build();
		return build;
	}
	
}
