package com.example.guitarChords;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.guitarChords.model.StringG4;
import com.example.guitarChords.model.StringG4Repository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StringG4RepositoryTest {

	@Autowired
	private StringG4Repository repository;
	
	// test that existing position can be found
	@Test
	public void findByPressWhereShouldReturnStringG4() {
		List<StringG4> stringG4s = repository.findByPressWhere("0|-----|-----|-----|-----|-----|-----|-----|");
		assertThat(stringG4s).hasSize(1);
	}
	
	// test create new position
	@Test
	public void shouldCreateNewStringG4() {
		StringG4 g4 = new StringG4("00000");
		repository.save(g4);
		assertThat(g4.getStringG4Id()).isNotNull();
	}
	
	// test delete position
	@Test
	public void shouldDeleteById() {
		StringG4 n = new StringG4("nnnn");
		StringG4 m = new StringG4("mmmm");
		repository.save(n);
		repository.save(m);
		
		repository.deleteById(n.getStringG4Id());
		Iterable<StringG4> g4s = repository.findAll();
		
		assertThat(g4s).contains(m);
		assertThat(g4s).doesNotContain(n);
		
	}
}
