package com.example.guitarChords.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ChordRepository extends CrudRepository<Chord, Long> {
	
	List<Chord> findByName(String name);
	List<Chord> findIdByName(String name);
}
