package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;

public interface IAuthService extends IService<User> {
	
	User findByEmailAndPassword(String email, String password);


}
