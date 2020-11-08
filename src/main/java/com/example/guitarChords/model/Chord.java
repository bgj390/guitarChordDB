package com.example.guitarChords.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Chord {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "stringE6Id")
	@JsonManagedReference
	private StringE6 stringE6;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "stringH5Id")
	@JsonManagedReference
	private StringH5 stringH5;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "stringG4Id")
	@JsonManagedReference
	private StringG4 stringG4;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "stringD3Id")
	@JsonManagedReference
	private StringD3 stringD3;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "stringA2Id")
	@JsonManagedReference
	private StringA2 stringA2;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "stringE1Id")
	@JsonManagedReference
	private StringE1 stringE1;
	
	public Chord() {}

	public Chord(String name, StringE6 stringE6, StringH5 stringH5, StringG4 stringG4, StringD3 stringD3, StringA2 stringA2, StringE1 stringE1) {
		super();
		this.name = name;
		this.stringE6 = stringE6;
		this.stringH5 = stringH5;
		this.stringG4 = stringG4;
		this.stringD3 = stringD3;
		this.stringA2 = stringA2;
		this.stringE1 = stringE1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StringE6 getStringE6() {
		return stringE6;
	}

	public void setStringE6(StringE6 stringE6) {
		this.stringE6 = stringE6;
	}

	public StringH5 getStringH5() {
		return stringH5;
	}

	public void setStringH5(StringH5 stringH5) {
		this.stringH5 = stringH5;
	}

	public StringG4 getStringG4() {
		return stringG4;
	}

	public void setStringG4(StringG4 stringG4) {
		this.stringG4 = stringG4;
	}

	public StringD3 getStringD3() {
		return stringD3;
	}

	public void setStringD3(StringD3 stringD3) {
		this.stringD3 = stringD3;
	}

	public StringA2 getStringA2() {
		return stringA2;
	}

	public void setStringA2(StringA2 stringA2) {
		this.stringA2 = stringA2;
	}
	
	public StringE1 getStringE1() {
		return stringE1;
	}

	public void setStringE1(StringE1 stringE1) {
		this.stringE1 = stringE1;
	}

	@Override
	public String toString() {
		return "Chord [name=" + name + 
				", stringE6=" + this.getStringE6() + 
				", stringH5=" + this.getStringH5() + 
				", stringG4=" + this.getStringG4() + 
				", stringD3=" + this.getStringD3() + 
				", stringA2=" + this.getStringA2() + 
				", stringE1=" + this.getStringE1() + 
				"]";
	}
	
	

}
