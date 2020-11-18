package com.example.guitarChords.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class StringE1 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stringE1Id;
	private String pressWhere;
	
	// database connection to chord
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stringE1")
	private List<Chord> chords;
	
	// constructors
	public StringE1() {}

	public StringE1(String pressWhere) {
		super();
		this.pressWhere = pressWhere;
	}

	// getters and setters
	public Long getStringE1Id() {
		return stringE1Id;
	}

	public void setStringE1Id(Long stringE1Id) {
		this.stringE1Id = stringE1Id;
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
		return "StringE1 [stringE1Id=" + stringE1Id + ", pressWhere=" + pressWhere + "]";
	}
}
