package com.example.guitarChords;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.guitarChords.model.Chord;
import com.example.guitarChords.model.ChordRepository;
import com.example.guitarChords.model.StringE1;
import com.example.guitarChords.model.StringA2;
import com.example.guitarChords.model.StringD3;
import com.example.guitarChords.model.StringG4;
import com.example.guitarChords.model.StringH5;
import com.example.guitarChords.model.StringE6;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ChordRepositoryTests {

	@Autowired
	private ChordRepository cRep;
	
	@Test
	public void findByNameShouldReturnChord() {
		List<Chord> chords = cRep.findByName("A");
		
		assertThat(chords).hasSize(1);
		assertThat(chords.get(0)).isNotNull();
	}
	
	@Test
	public void ShouldCreateNewChord() {
		Chord chord = new Chord("E7sus4", new StringE6("0|-----|-----|-----|-----|-----|-----|-----|"), new StringH5("0|-----|-----|-----|-----|-----|-----|-----|"), new StringG4("0|-----|-----|-----|-----|-----|-----|-----|"), new StringD3("0|-----|-----|-----|-----|-----|-----|-----|"), new StringA2("0|-----|-----|-----|-----|-----|-----|-----|"), new StringE1("0|-----|-----|-----|-----|-----|-----|-----|"));
		cRep.save(chord);
		assertThat(chord.getId()).isNotNull();
		assertThat(chord.getName()).isEqualTo("E7sus4");
		assertThat(chord.getStringE1()).isNotNull();
		assertThat(chord.getStringA2()).isNotNull();
		assertThat(chord.getStringD3()).isNotNull();
		assertThat(chord.getStringG4()).isNotNull();
		assertThat(chord.getStringH5()).isNotNull();
		assertThat(chord.getStringE6()).isNotNull();
	}
	
	@Test
	public void shouldDeleteAll() {
		cRep.deleteAll();
		Iterable<Chord> chords = cRep.findAll();
		assertThat(chords).hasSize(0);
	}
}
