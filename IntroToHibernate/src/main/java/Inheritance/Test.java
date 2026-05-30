package Inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
        EntityManager em = emf.createEntityManager();
        MyProduct p = new MyProduct();
        Book b = new Book();
        
        
        p.setId(21);
        p.setName("Car");
        
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
	}
}
