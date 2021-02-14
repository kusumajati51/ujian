package com.test.user.app.services.db_service.implementor;

import java.util.List;

import com.test.user.app.model.User;
import com.test.user.app.repository.UserRepositoryJpa;
import com.test.user.app.services.db_service.service.UserRepoService;

import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceImpl implements UserRepoService{
    @Autowired
    UserRepositoryJpa userRepo;

    @Override
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    @Override
	public User getUserById(int id){
        return userRepo.findById(id).get();
    }
    @Override
	public void addUser(User user){
        userRepo.save(user);
    }

    @Override
	public void deleteUser(int id){
        userRepo.deleteById(id);
    }

}
