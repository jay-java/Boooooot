package com.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.model.User;
import com.jsp.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	public void addNewUser(User u) {
		this.repo.save(u);
	}

	public List<User> getAllUsers() {
		return (List<User>) this.repo.findAll();
	}

	public void deleteUser(int id) {
		this.repo.deleteById(id);
	}

	public Optional<User> findUserById(int id) {
		return this.repo.findById(id);
	}

}
