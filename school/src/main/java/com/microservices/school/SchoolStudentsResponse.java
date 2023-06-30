package com.microservices.school;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SchoolStudentsResponse {
	private String schoolName;
	private List<Students> student;
}
