package com.microservices.school;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "student",url = "http://localhost:8002/api/v1/student/")
public interface StudentClient {
	@RequestMapping(method = RequestMethod.GET, value = "{school-id}")
	List<Students> findAllStudentsBySchoolId(@PathVariable("school-id") Long schoolId);
}
