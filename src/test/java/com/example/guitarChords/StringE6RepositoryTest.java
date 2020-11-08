package com.example.guitarChords;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.guitarChords.model.StringE6;
import com.example.guitarChords.model.StringE6Repository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StringE6RepositoryTest {

	@Autowired
	private StringE6Repository repository;
	
	@Test
	public void findByPressWhereShouldReturnStringE6() {
		List<StringE6> stringE6s = repository.findByPressWhere("0|-----|-----|-----|-----|-----|-----|-----|");
		assertThat(stringE6s).hasSize(1);
	}
	
	@Test
	public void shouldCreateNewStringE6() {
		StringE6 e6 = new StringE6("00000");
		repository.save(e6);
		assertThat(e6.getStringE6Id()).isNotNull();
	}
	
	@Test
	public void shouldDeleteById() {
		StringE6 n = new StringE6("nnnn");
		StringE6 m = new StringE6("mmmm");
		repository.save(n);
		repository.save(m);
		
		repository.deleteById(n.getStringE6Id());
		Iterable<StringE6> e6s = repository.findAll();
		
		assertThat(e6s).contains(m);
		assertThat(e6s).doesNotContain(n);
		
	}
}
