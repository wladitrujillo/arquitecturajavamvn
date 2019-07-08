package com.arquitecturajava.aplicacion.bo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author      cecilio alvarez caules contacto@arquitecturajava.com
 * @version     1.0                        
 */
public class JPAHelper {

	private static final EntityManagerFactory emf = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {

		try {

			// Create the SessionFactory from hibernate.cfg.xml

			return Persistence.createEntityManagerFactory("arquitecturaJava");

		}

		catch (Throwable ex) {

			System.err.println("Error creando una factoria de session." + ex);

			throw new RuntimeException("Error al crear la factoria de JPA");

		}

	}

	public static EntityManagerFactory getJPAFactory() {

		return emf;

	}

}