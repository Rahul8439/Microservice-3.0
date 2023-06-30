package com.microservices.school;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Students implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6301545720273933796L;
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private Long schoolId;
}
