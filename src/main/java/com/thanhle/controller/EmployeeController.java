package com.thanhle.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thanhle.domain.Employee;
import com.thanhle.domain.Gender;
import com.thanhle.service.EmployeeService;
import com.thanhle.validation.EmployeeValidator;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	@Autowired EmployeeValidator employeeValidator;
	
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		binder.addValidators(employeeValidator);
	}
	
	@RequestMapping("employeeForm")
	public String  employeeForm(Employee employee, Model model) {
		
		
		/*
		model.addAttribute("employees", employeeService.findAll());
		
		String[] hobbies = {"Swimming", "Boating", "Cyclicng", "Football", "Cricket"};
		model.addAttribute("hobbies", hobbies);
		
		List<String> spokenLanguages  = new ArrayList<>();
		spokenLanguages.add("English");
		spokenLanguages.add("French");
		spokenLanguages.add("Spanish");
		spokenLanguages.add("Arabic");
		spokenLanguages.add("Chinese");
		spokenLanguages.add("Hindi");
		spokenLanguages.add("Others");
		model.addAttribute("spokenLanguages", spokenLanguages);
		
		Set<String> skills = new HashSet<>();
		skills.add("Java");
		skills.add("MySQL");
		skills.add("Oracle");
		skills.add("NoSQL");
		skills.add("Spring");
		skills.add("Hibernate");
		model.addAttribute("skills", skills);
		
		model.addAttribute("genders", Gender.values());
		*/
		modelData(model);
		
		return "employeeForm";
	}
	
	@RequestMapping("saveEmployee")
	public String  saveTheEmployee(@Valid Employee employee, BindingResult br, Model model) {
		//employeeValidator.validate(employee, br);
		if(!br.hasErrors()) {
			employeeService.save(employee);
		}
		
		
		System.out.println("saveEmployee - phoneNumber: "+employee.getPhoneNumber());
		model.addAttribute("employees", employeeService.findAll());
		
		String[] hobbies = {"Swimming", "Boating", "Cyclicng", "Football", "Cricket"};
		model.addAttribute("hobbies", hobbies);
		
		List<String> spokenLanguages  = new ArrayList<>();
		spokenLanguages.add("English");
		spokenLanguages.add("French");
		spokenLanguages.add("Spanish");
		spokenLanguages.add("Arabic");
		spokenLanguages.add("Chinese");
		spokenLanguages.add("Hindi");
		spokenLanguages.add("Others");
		model.addAttribute("spokenLanguages", spokenLanguages);
		
		Set<String> skills = new HashSet<>();
		skills.add("Java");
		skills.add("MySQL");
		skills.add("Oracle");
		skills.add("NoSQL");
		skills.add("Spring");
		skills.add("Hibernate");
		model.addAttribute("skills", skills);
		model.addAttribute("genders", Gender.values());
		
		return "employeeForm";
	}
	
	@RequestMapping("update")
	public String  updateTheEmployee(Employee employee, Model model) {
		employee = employeeService.findById(employee.getEmpId());
		model.addAttribute("employee", employee);
		modelData(model);
		
		/*
		String[] hobbies = {"Swimming", "Boating", "Cyclicng", "Football", "Cricket"};
		model.addAttribute("hobbies", hobbies);
		
		List<String> spokenLanguages  = new ArrayList<>();
		spokenLanguages.add("English");
		spokenLanguages.add("French");
		spokenLanguages.add("Spanish");
		spokenLanguages.add("Arabic");
		spokenLanguages.add("Chinese");
		spokenLanguages.add("Hindi");
		spokenLanguages.add("Others");
		model.addAttribute("spokenLanguages", spokenLanguages);
		
		Set<String> skills = new HashSet<>();
		skills.add("Java");
		skills.add("MySQL");
		skills.add("Oracle");
		skills.add("NoSQL");
		skills.add("Spring");
		skills.add("Hibernate");
		model.addAttribute("skills", skills);
		model.addAttribute("genders", Gender.values());
		
		model.addAttribute("employees", employeeService.findAll());
		*/
		return "employeeForm";
	}
	
	@RequestMapping("delete")
	public String  deleteTheEmployee(Employee employee, Model model) {
		employeeService.deleteById(employee.getEmpId());
		modelData(model);
		
		return "employeeForm";
	}
	
   public void modelData(Model model) {

		model.addAttribute("employees", employeeService.findAll());
		String[] hobbies = {"Swimming", "Boating", "Cyclicng", "Football", "Cricket"};
		model.addAttribute("hobbies", hobbies);
		
		List<String> spokenLanguages  = new ArrayList<>();
		spokenLanguages.add("English");
		spokenLanguages.add("French");
		spokenLanguages.add("Spanish");
		spokenLanguages.add("Arabic");
		spokenLanguages.add("Chinese");
		spokenLanguages.add("Hindi");
		spokenLanguages.add("Others");
		model.addAttribute("spokenLanguages", spokenLanguages);
		
		Set<String> skills = new HashSet<>();
		skills.add("Java");
		skills.add("MySQL");
		skills.add("Oracle");
		skills.add("NoSQL");
		skills.add("Spring");
		skills.add("Hibernate");
		model.addAttribute("skills", skills);
		model.addAttribute("genders", Gender.values());
	}

}
