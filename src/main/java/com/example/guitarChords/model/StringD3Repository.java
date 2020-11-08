package com.example.guitarChords.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StringD3Repository extends CrudRepository<StringD3, Long> {
	
	List<StringD3> findByPressWhere(String pressWhere);
}
