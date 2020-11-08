package com.example.guitarChords;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.guitarChords.model.StringA2;
import com.example.guitarChords.model.StringA2Repository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StringA2RepositoryTest {

	@Autowired
	private StringA2Repository repository;
	
	@Test
	public void findByPressWhereShouldReturnStringA2() {
		List<StringA2> stringA2s = repository.findByPressWhere("0|-----|-----|-----|-----|-----|-----|-----|");
		assertThat(stringA2s).hasSize(1);
	}
	
	@Test
	public void shouldCreateNewStringA2() {
		StringA2 a2 = new StringA2("00000");
		repository.save(a2);
		assertThat(a2.getStringA2Id()).isNotNull();
	}
	
	@Test
	public void shouldDeleteById() {
		StringA2 n = new StringA2("nnnn");
		StringA2 m = new StringA2("mmmm");
		repository.save(n);
		repository.save(m);
		
		repository.deleteById(n.getStringA2Id());
		Iterable<StringA2> a2s = repository.findAll();
		
		assertThat(a2s).contains(m);
		assertThat(a2s).doesNotContain(n);
		
	}
}
