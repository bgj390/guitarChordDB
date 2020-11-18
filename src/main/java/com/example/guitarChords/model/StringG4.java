package com.example.guitarChords.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class StringG4 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stringG4Id;
	private String pressWhere;
	
	// database connection to chord 
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stringG4")
	private List<Chord> chords;
	
	// constructors
	public StringG4() {}

	public StringG4(String pressWhere) {
		super();
		this.pressWhere = pressWhere;
	}

	// getters and setters
	public Long getStringG4Id() {
		return stringG4Id;
	}

	public void setStringG4Id(Long stringG4Id) {
		this.stringG4Id = stringG4Id;
	}

	public String getPressWhere() {
		return pressWhere;
	}

	public void setPressWhere(String pressWhere) {
		this.pressWhere = pressWhere;
	}

	public List<Chord> getChords() {
		return chords;
	}

	public void setChords(List<Chord> chords) {
		this.chords = chords;
	}

	// toString method
	@Override
	public String toString() {
		return "StringG4 [stringG4Id=" + stringG4Id + ", pressWhere=" + pressWhere + "]";
	}
}
