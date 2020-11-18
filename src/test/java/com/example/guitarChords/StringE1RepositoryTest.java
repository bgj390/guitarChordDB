package com.example.guitarChords;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.guitarChords.model.StringE1;
import com.example.guitarChords.model.StringE1Repository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StringE1RepositoryTest {

	@Autowired
	private StringE1Repository repository;
	
	// test that existing position can be found
	@Test
	public void findByPressWhereShouldReturnStringE1() {
		List<StringE1> stringE1s = repository.findByPressWhere("0|-----|-----|-----|-----|-----|-----|-----|");
		assertThat(stringE1s).hasSize(1);
	}
	
	// test create new position
	@Test
	public void shouldCreateNewStringE1() {
		StringE1 e1 = new StringE1("00000");
		repository.save(e1);
		assertThat(e1.getStringE1Id()).isNotNull();
	}
	
	// test delete position
	@Test
	public void shouldDeleteById() {
		StringE1 n = new StringE1("nnnn");
		StringE1 m = new StringE1("mmmm");
		repository.save(n);
		repository.save(m);
		
		repository.deleteById(n.getStringE1Id());
		Iterable<StringE1> e1s = repository.findAll();
		
		assertThat(e1s).contains(m);
		assertThat(e1s).doesNotContain(n);
		
	}
}
