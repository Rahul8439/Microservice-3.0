package com.microservices.student;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Students implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4358451118739650202L;
	@Id
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private Long schoolId;
}
