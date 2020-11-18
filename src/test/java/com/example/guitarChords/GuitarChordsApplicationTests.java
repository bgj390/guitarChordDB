package com.example.guitarChords;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.guitarChords.web.ChordController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GuitarChordsApplicationTests {

	@Autowired
	private ChordController controller;
	
	// test ChordController exists
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		}
}
