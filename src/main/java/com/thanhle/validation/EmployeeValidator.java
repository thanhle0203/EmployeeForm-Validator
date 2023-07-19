package com.thanhle.validation;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.thanhle.domain.Employee;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee e = (Employee)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "employee.name", "Name is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "employee.designation", "Designation is a required field.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "employee.salary", "Salary is a required field.");
		
		if(e.getName().length() <2) {
			errors.rejectValue("name", "employee.name.length", "Employee name is too short.");
		}
		
		if(e.getSalary() < 15000) {
			errors.rejectValue("salary", "employee.salary.value", "Salary should not be less than $15000.");
		}
		
		System.out.println("e.getDob().getYear(): "+e.getDob().getYear());
		
		//Duration d = Duration.between(LocalDate.now(), e.getDob());
		//System.out.println("d: "+d);
		
		/*
		if(e.getDob().getYear()<21) {
			
			errors.rejectValue("dob", "employee.dob.value", "Age should not be less than 21 years.");
		}
		*/
		if(e.getGender()==null) {
			errors.rejectValue("gender", "employee.gender.value", "Gender is a required field.");
		}
		
		//System.out.println("e.getCitizenship(): "+e.getCitizenship());
		if(e.getCitizenship()== null) {
			errors.rejectValue("citizenship", "employee.citizenship.value", "Citizenship is a required field.");
		}
		
		if(e.getHobbies().length<1) {
			errors.rejectValue("hobbies", "employee.hobbies.value", "Hobbies is a required field.");
		}
		
		if(e.getSpokenLanguages().size()<1) {
			errors.rejectValue("spokenLanguages", "employee.spokenLanguages.value", "SpokenLanguages is a required field.");
		}
		
		if(e.getSkills().size()<1) {
			errors.rejectValue("skills", "employee.skills.value", "Skills is a required field.");
		}
		
		if(e.getPhoneNumber().length() !=10) {
			errors.rejectValue("phoneNumber", "employee.phoneNumbe.value", "PhoneNumbe is a required field.");
		}
		
		if(e.getAddress().getAddressLine1().isBlank()) {
			errors.rejectValue("address.addressLine1", "employee.address.addressLine1.value", "Address Line1 is a required field.");
		}
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		jakarta.validation.Validator validator  =  validatorFactory.getValidator();
		
		Set<ConstraintViolation<Employee>>   violations = validator.validate(e);
		
		System.out.println("\nFollowing are the violation with their invalid value: ");
		for(ConstraintViolation<Employee> violation : violations) {
			System.out.println(violation.getPropertyPath() +": "+violation.getInvalidValue());
		}
	}

}
