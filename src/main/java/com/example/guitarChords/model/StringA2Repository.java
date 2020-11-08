package com.example.guitarChords.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StringA2Repository extends CrudRepository<StringA2, Long> {
	
	List<StringA2> findByPressWhere(String pressWhere);
}
