package Anudip.E_Commerce_App.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmUtil {
private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("myStore");
	}
	
	public static EntityManager provideEntityManager() {
		return emf.createEntityManager();
	}
}
