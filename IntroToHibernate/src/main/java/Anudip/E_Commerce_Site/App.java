package Anudip.E_Commerce_Site;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentUnit");
        EntityManager em = emf.createEntityManager();
        Scanner io = new Scanner(System.in);
              
        //insert
        em.getTransaction().begin();
        em.persist(new Product(24, "DolphinToy"));
        em.getTransaction().commit();
        em.close();
        
        
//        //delete
//        int productId = io.nextInt();
//        Product product_id = em.find(Product.class, productId);
//        if(product_id!=null) {
//        	em.getTransaction().begin();
//        	em.remove(product_id);
//        	em.getTransaction().commit();
//        	em.close();
//        	System.out.println("Product is Removed");
//        } else {
//        	System.out.println("There is no product of this id.");
//
//        }
//        		
//        //update
//        System.out.println("please enter the product id  that you want to update "); 
//        int p_id = io.nextInt();
//        Product pId = em.find(Product.class, p_id);
//        if(pId!=null) {
//        	String name = pId.getProductName();
//        	System.out.println("This is previous name = "+name+" \n please Enter That name ,you want to change ");
//        	String newName = io.next();
//        	em.getTransaction().begin();
//        	pId.setProductName(newName);
//        	em.getTransaction().commit();
//        	System.out.println("now product name is update ");
//         	em.close();
//        } else {
//        	System.out.println("There is no product of this id.");
//        }
        io.close();
    }
}
