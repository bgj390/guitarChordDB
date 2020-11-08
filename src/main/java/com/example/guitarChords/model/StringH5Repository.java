package com.example.guitarChords.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StringH5Repository extends CrudRepository<StringH5, Long> {
	
	List<StringH5> findByPressWhere(String pressWhere);
}
