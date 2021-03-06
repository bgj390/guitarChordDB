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
public class StringH5 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stringH5Id;
	private String pressWhere;
	
	// database connection to chord
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stringH5")
	private List<Chord> chords;
	
	// constructors
	public StringH5() {}

	public StringH5(String pressWhere) {
		super();
		this.pressWhere = pressWhere;
	}

	// getters and setters
	public Long getStringH5Id() {
		return stringH5Id;
	}

	public void setStringH5Id(Long stringH5Id) {
		this.stringH5Id = stringH5Id;
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
		return "StringH5 [stringH5Id=" + stringH5Id + ", pressWhere=" + pressWhere + "]";
	}
}
