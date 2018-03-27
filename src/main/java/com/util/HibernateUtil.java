package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			//return new AnnotationConfiguration().configure().buildSessionFactory();
			Configuration configure = new AnnotationConfiguration().configure("hibernate.cfg.xml");// config load
			SessionFactory sessionFactory=configure.buildSessionFactory();// pool of session/connection will be created
			return sessionFactory;

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
