package com.microservices.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository repository;
	
	@Autowired
	private ObjectMapper mapper;

	public void saveStudent(Students student) {
		repository.save(student);
	}
	
	public List<Students> findAllStudents(){
		return repository.findAll();
	}

	public List<Students> findAllStudentsBySchoolId(Long schoolId) {
		
		return repository.findBySchoolId(schoolId);
	}
	
}
