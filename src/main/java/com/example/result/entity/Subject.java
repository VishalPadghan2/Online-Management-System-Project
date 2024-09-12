package com.example.result.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Subject {
	
	@Id
	@SequenceGenerator(name = "seq_subject")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_subject")
	Long id;
	String name;
	String code;
	Integer minMarks;
	Integer maxMarks;
	
	public Subject() {
		super();
	}
	public Subject(String name, String code, Integer minMarks, Integer maxMarks) {
		super();
		this.name = name;
		this.code = code;
		this.minMarks = minMarks;
		this.maxMarks = maxMarks;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getMinMarks() {
		return minMarks;
	}
	public void setMinMarks(Integer minMarks) {
		this.minMarks = minMarks;
	}
	public Integer getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(Integer maxMarks) {
		this.maxMarks = maxMarks;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", code=" + code + ", minMarks=" + minMarks + ", maxMarks="
				+ maxMarks + "]";
	}
	
	

}
