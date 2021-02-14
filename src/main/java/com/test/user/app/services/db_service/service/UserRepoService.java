package com.test.user.app.services.db_service.service;

import java.util.List;

import com.test.user.app.model.User;

public interface UserRepoService {
    public List<User> getAllUsers();
	public User getUserById(int id);
	public void addUser(User user);
	public void deleteUser(int id);
}
