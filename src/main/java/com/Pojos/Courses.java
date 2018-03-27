package com.Pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Courses {
	@Id
	@GeneratedValue
	private int courseId;
	private String courseName;
	private int duration;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Students_Courses", joinColumns = { @JoinColumn(name = "courseId") }, inverseJoinColumns = { @JoinColumn(name = "studentID") })
	private List<ManyStudents> manyStudents;

	public List<ManyStudents> getManyStudents() {
		return manyStudents;
	}

	public void setManyStudents(List<ManyStudents> manyStudents) {
		this.manyStudents = manyStudents;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}