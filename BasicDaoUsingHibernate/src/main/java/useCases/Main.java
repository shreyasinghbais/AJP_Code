 package useCases;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.ProducctDao;
import daoImpl.ProductDaoImpl;
import model.Product;

public class Main {
    public static void main(String[] args) { 
        
        //Use DAO for Product Operations
    	ProducctDao dao = new ProductDaoImpl();
    
        Product p1 = new Product(); 
        p1.setProductId(9);
        p1.setProductName("Glue-Gun");
        p1.setProductPrice(500);
        p1.setCategory("Stationary");
        p1.setDate(new Date());
        
        boolean ans = dao.updateProduct(p1);  
        System.out.println("Product updated: " + ans);       
   }
}

