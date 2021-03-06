package com.loiane.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.loiane.com.model.City;

/**
 * The HibernateUtil class helps in creating the SessionFactory
 * from the Hibernate configuration file
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new AnnotationConfiguration()
								.configure()
								.addPackage("com.loiane.model") //the fully qualified package name
								.addAnnotatedClass(City.class)
								.buildSessionFactory();
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}