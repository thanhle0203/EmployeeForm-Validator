package com.thanhle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhle.domain.User;
import com.thanhle.repository.UserRepository ;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(long userId) {
		Optional<User> optUser = userRepository.findById(userId);
		if(optUser.isPresent()) {
			return optUser.get();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User updateById(long userId) {
		return userRepository.getById(userId);
	}

	@Override
	public void deleteById(long userId) {
		userRepository.deleteById(userId);

	}

}

