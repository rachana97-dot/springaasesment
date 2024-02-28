package com.assesment.assesment.service;

import java.util.Random;

import org.aspectj.apache.bcel.classfile.Module.Uses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.assesment.model.User;
import com.assesment.assesment.repository.UserRepository;

@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepository;

	    public User saveUser(User user) {
	        // Generate password using JavaScript-like logic
	        String generatedPassword = generatePassword(user.getFirstName(), user.getMiddleName(), user.getLastName());
	        user.setPassword(generatedPassword);

	        // Save user to the database
	        return userRepository.save(user);
	    }

	    private String generatePassword(String firstName, String middleName, String lastName) {
	        // JavaScript-like logic for generating a password
	        String password = firstName.substring(0, 2) + middleName.substring(0, 2) + lastName.substring(0, 2);
	        password += String.format("%03d", new Random().nextInt(1000)); // 3-digit random number

	        return password;
	    }

}
