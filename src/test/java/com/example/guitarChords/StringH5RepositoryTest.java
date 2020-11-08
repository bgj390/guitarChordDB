package com.example.guitarChords;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.guitarChords.model.StringH5;
import com.example.guitarChords.model.StringH5Repository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StringH5RepositoryTest {

	@Autowired
	private StringH5Repository repository;
	
	@Test
	public void findByPressWhereShouldReturnStringH5() {
		List<StringH5> stringH5s = repository.findByPressWhere("0|-----|-----|-----|-----|-----|-----|-----|");
		assertThat(stringH5s).hasSize(1);
	}
	
	@Test
	public void shouldCreateNewStringH5() {
		StringH5 h5 = new StringH5("00000");
		repository.save(h5);
		assertThat(h5.getStringH5Id()).isNotNull();
	}
	
	@Test
	public void shouldDeleteById() {
		StringH5 n = new StringH5("nnnn");
		StringH5 m = new StringH5("mmmm");
		repository.save(n);
		repository.save(m);
		
		repository.deleteById(n.getStringH5Id());
		Iterable<StringH5> h5s = repository.findAll();
		
		assertThat(h5s).contains(m);
		assertThat(h5s).doesNotContain(n);
		
	}
}
