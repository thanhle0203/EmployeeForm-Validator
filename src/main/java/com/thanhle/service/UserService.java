package com.thanhle.service;

import java.util.List;

import com.thanhle.domain.User;

public interface UserService {
	public User save(User user);
	public User findById(long userId);
	public List<User> findAll();
	
	public User updateById(long userId);
	public void deleteById(long userId);
	
}