package com.example.result.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {
	
	@Id
	@SequenceGenerator(name = "seq_student")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_student")
	Long id;
	String firstName;
	String lastName;
	String motherName;
	String fatherName;
	String seatNo;
	public Student() {
		super();
	}
	public Student(String firstName, String lastName, String motherName, String fatherName, String seatNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.fatherName = fatherName;
		this.seatNo = seatNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", motherName="
				+ motherName + ", fatherName=" + fatherName + ", seatNo=" + seatNo + "]";
	}
	
	

}
