package com.thanhle.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Role {
	
	@NotNull(message = "*Role Id must not be null.")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roleId;
	
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users = new HashSet<>();
	
	Role(){
		
	}
	
	Role(Long roleId, String name){
		this.roleId = roleId;
		this.name = name;
	}
	
	Role(String name){
		this.name = name;
	}

	

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", users=" + users + "]";
	}
	
	


}
