package com.example.guitarChords;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.guitarChords.model.StringD3;
import com.example.guitarChords.model.StringD3Repository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StringD3RepositoryTest {

	@Autowired
	private StringD3Repository repository;
	
	@Test
	public void findByPressWhereShouldReturnStringD3() {
		List<StringD3> stringD3s = repository.findByPressWhere("0|-----|-----|-----|-----|-----|-----|-----|");
		assertThat(stringD3s).hasSize(1);
	}
	
	@Test
	public void shouldCreateNewStringD3() {
		StringD3 d3 = new StringD3("00000");
		repository.save(d3);
		assertThat(d3.getStringD3Id()).isNotNull();
	}
	
	@Test
	public void shouldDeleteById() {
		StringD3 n = new StringD3("nnnn");
		StringD3 m = new StringD3("mmmm");
		repository.save(n);
		repository.save(m);
		
		repository.deleteById(n.getStringD3Id());
		Iterable<StringD3> d3s = repository.findAll();
		
		assertThat(d3s).contains(m);
		assertThat(d3s).doesNotContain(n);
		
	}
}
