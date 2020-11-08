package com.example.guitarChords.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StringE1Repository extends CrudRepository<StringE1, Long> {
	
	List<StringE1> findByPressWhere(String pressWhere);
}

