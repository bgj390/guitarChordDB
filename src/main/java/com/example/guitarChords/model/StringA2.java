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
public class StringA2 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stringA2Id;
	private String pressWhere;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stringA2")
	private List<Chord> chords;
	
	public StringA2() {}

	public StringA2(String pressWhere) {
		super();
		this.pressWhere = pressWhere;
	}

	public Long getStringA2Id() {
		return stringA2Id;
	}

	public void setStringA2Id(Long stringA2Id) {
		this.stringA2Id = stringA2Id;
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

	@Override
	public String toString() {
		return "StringA2 [stringA2Id=" + stringA2Id + ", pressWhere=" + pressWhere + "]";
	}
}
