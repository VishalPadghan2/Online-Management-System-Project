package com.example.result.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class MarksheetDetails {
	
	@Id
	@SequenceGenerator(name = "seq_marksheet_details")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marksheet_details")
	Long id;
	Long idMarksheet;
	Long idSubject;
	Integer marks;
	public MarksheetDetails() {
		super();
	}
	public MarksheetDetails(Long idMarksheet, Long idSubject, Integer marks) {
		super();
		this.idMarksheet = idMarksheet;
		this.idSubject = idSubject;
		this.marks = marks;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdMarksheet() {
		return idMarksheet;
	}
	public void setIdMarksheet(Long idMarksheet) {
		this.idMarksheet = idMarksheet;
	}
	public Long getIdSubject() {
		return idSubject;
	}
	public void setIdSubject(Long idSubject) {
		this.idSubject = idSubject;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "MarksheetDetails [id=" + id + ", idMarksheet=" + idMarksheet + ", idSubject=" + idSubject + ", marks="
				+ marks + "]";
	}

	
}
