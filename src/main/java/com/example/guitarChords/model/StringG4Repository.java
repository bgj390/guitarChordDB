package com.example.guitarChords.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StringG4Repository extends CrudRepository<StringG4, Long> {
	
	List<StringG4> findByPressWhere(String pressWhere);
}
