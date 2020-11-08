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
public class StringD3 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long stringD3Id;
	private String pressWhere;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stringD3")
	private List<Chord> chords;
	
	public StringD3() {}

	public StringD3(String pressWhere) {
		super();
		this.pressWhere = pressWhere;
	}

	public Long getStringD3Id() {
		return stringD3Id;
	}

	public void setStringD3Id(Long stringD3Id) {
		this.stringD3Id = stringD3Id;
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
		return "StringD3 [stringD3Id=" + stringD3Id + ", pressWhere=" + pressWhere + "]";
	}
}
