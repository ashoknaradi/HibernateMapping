package com.Pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class College {
	@Id
	@GeneratedValue
	private int collegeId;
	private String collegeName;
	private String collegeLocation;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="universityId")
	private University university;

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeLocation() {
		return collegeLocation;
	}

	public void setCollegeLocation(String collegeLocation) {
		this.collegeLocation = collegeLocation;
	}

}
