package com.example.guitarChords.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.guitarChords.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
		User findByUsername(String username);
	
	//	User saveUser(User user);
}
