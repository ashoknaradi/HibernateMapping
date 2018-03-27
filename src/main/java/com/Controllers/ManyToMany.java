package com.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Pojos.College;
import com.Pojos.Courses;
import com.Pojos.ManyStudents;
import com.util.HibernateUtil;

public class ManyToMany {
	public static void main(String[] args) {
		save();
		//read();
	}

	private static void read() {
		System.out.println("Hibernate many to many (Annotation) read method()");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction beginTransaction = session.beginTransaction();
		Query query = session.createQuery("from Courses where courseName='GWT'");
		List<ManyStudents> list = query.list();
		for (ManyStudents manyStudents : list) {
			System.out.println("manyStudents.getStudentName() ======== "
					+ manyStudents.getStudentName());
			System.out.println("manyStudents.getStudentMobile ======== "
					+ manyStudents.getStudentMobile());
		}
		System.out.println("Done!......");
		session.close();
	}

	private static void save() {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction beginTransaction = session.beginTransaction();

		ManyStudents student1 = new ManyStudents();
		student1.setStudentName("r");
		student1.setStudentCity("r");
		student1.setStudentMobile("r");
		
		ManyStudents student2 = new ManyStudents();
		student2.setStudentName("k");
		student2.setStudentCity("k");
		student2.setStudentMobile("k");
		
		Courses course1 = new Courses();
		course1.setCourseName("AWS");
		course1.setDuration(40);
		
		Courses course2 = new Courses();
		course2.setCourseName("Spring");
		course2.setDuration(60);
		
		//Many-To-Many
		List<Courses> list = new ArrayList<Courses>();
		list.add(course1);
		list.add(course2);
		
		student1.setCourses(list);
		student2.setCourses(list);
		session.save(student1);
		session.save(student2);
	    
		beginTransaction.commit();
		System.out.println("Done");
		session.close();
	}
}