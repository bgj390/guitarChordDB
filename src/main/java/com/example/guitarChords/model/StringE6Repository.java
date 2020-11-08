package com.example.guitarChords.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StringE6Repository extends CrudRepository<StringE6, Long> {
	
	List<StringE6> findByPressWhere(String pressWhere);
}
