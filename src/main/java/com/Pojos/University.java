package com.Pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class University {
	@Id
	@GeneratedValue
	private int universityId;
	private String universityName;
	private String universityLocation;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="universityId")
    private List<College> college;
	
	public List<College> getCollege() {
		return college;
	}

	public void setCollege(List<College> college) {
		this.college = college;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getUniversityLocation() {
		return universityLocation;
	}

	public void setUniversityLocation(String universityLocation) {
		this.universityLocation = universityLocation;
	}

}
