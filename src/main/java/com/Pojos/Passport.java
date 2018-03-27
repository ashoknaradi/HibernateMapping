package com.Pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private int passportID;
	private String passportNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="studentID")
    Student student;

	public int getPassportID() {
		return passportID;
	}

	public void setPassportID(int passportID) {
		this.passportID = passportID;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
