package com.Controllers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Pojos.Passport;
import com.Pojos.Student;
import com.util.HibernateUtil;

public class oneToOneMain {
	public static void main(String[] args) {
		save();
		//read();
	}

	private static void read() {
		System.out.println("Hibernate one to one (Annotation) read method()");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction beginTransaction = session.beginTransaction();	
		Query query = session.createQuery("from Student where studentName='s'");
		List<Student> list = query.list();
		for( Student student : list) {
			System.out.println("student.getPassport().getPassportID()======== " + student.getPassport().getPassportID());
			System.out.println("student.getPassport().getPassportNumber()======== " + student.getPassport().getPassportNumber());
		}
		System.out.println("Done!......");
		session.close();
	}

	private static void save() {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction beginTransaction = session.beginTransaction();

		Student student = new Student();
		student.setStudentName("as");
		student.setStudentCity("as");
		student.setStudentMobile("99");
		Passport passport = new Passport();
		passport.setPassportNumber("99");
		

		//Uni-Direction
		/*passport.setStudent(student);
		session.save(passport);*/
		
		//Bi-Direction
		student.setPassport(passport);
		passport.setStudent(student);
		session.save(student);
		
		beginTransaction.commit();
		System.out.println("Done");
		session.close();
	}
}