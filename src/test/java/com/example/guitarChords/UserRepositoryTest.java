package com.example.guitarChords;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.guitarChords.model.User;
import com.example.guitarChords.model.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository uRep;
	
	// test find user by username
	@Test
	public void findByUsernameShuoldReturnUser() {
		User user = uRep.findByUsername("user");
		assertThat(user.getRole()).isEqualTo("USER");
	}
}
