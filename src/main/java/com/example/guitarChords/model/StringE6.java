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
public class StringE6 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stringE6Id;
	private String pressWhere;
	
	// database connection to chord
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stringE6")
	private List<Chord> chords;
	
	// constructors
	public StringE6() {}

	public StringE6(String pressWhere) {
		super();
		this.pressWhere = pressWhere;
	}

	// getters and setters
	public Long getStringE6Id() {
		return stringE6Id;
	}

	public void setStringE6Id(Long stringE6Id) {
		this.stringE6Id = stringE6Id;
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
		return "StringE6 [stringE6Id=" + stringE6Id + ", pressWhere=" + pressWhere + "]";
	}
}
