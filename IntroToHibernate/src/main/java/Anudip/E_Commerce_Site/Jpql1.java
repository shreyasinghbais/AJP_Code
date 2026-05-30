package Anudip.E_Commerce_Site;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Jpql1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
		EntityManager em = emf.createEntityManager();
		
		// we all students name in upper case 
//	    Query  query  = em.createQuery("select Upper(s.productName) from Product s");
//		List<String>  list = query.getResultList();
//		
//		for( String name : list){
//			System.out.print(name +" ");
//		}
		
		
		//write a query to get all students who are starting with D
	
		Query q  = em.createQuery("select p.productname from Product p where p.productname like 'D%'") ;
		List<Product>  list  =  q.getResultList();
		for( Product p : list){
			System.out.print(p);
		}
		
		 
	}
}
