package com.thanhle.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderColumn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@ToString
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	
	@Size(min = 3, max = 20)
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String designation;
	
	@Digits(integer = 5, fraction=0, message="Salary accepts only digits.")
	private int salary;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate dob;
	
	//@Enumerated(EnumType.STRING)
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	
	@NotEmpty
	private String citizenship;
	
	@OrderColumn
	private String[] hobbies;
	
	@ElementCollection
	@NotNull
	private List<String> spokenLanguages = new ArrayList<>();
	
	@ElementCollection
	@NotNull
	private Set<String> skills = new HashSet<>();
	
	private boolean insured;
	
	private String phoneNumber;
	
	@Email
	@NotEmpty
	private String email;
	
	@Embedded
	@Valid
	private Address address;
	
	
	Employee(int empId, String name, String designation, int salary){
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	
	
	

}
