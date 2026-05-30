package Anudip.E_Commerce_App.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Anudip.E_Commerce_App.dao.ProductDao; 
import Anudip.E_Commerce_App.exception.ProductException;
import Anudip.E_Commerce_App.model.Category;
import Anudip.E_Commerce_App.model.Products;
import Anudip.E_Commerce_App.utility.EmUtil;

public class ProductDaoImpl implements ProductDao{
	
	EntityManager em = EmUtil.provideEntityManager();
	EntityTransaction transaction = em.getTransaction();
	
	@Override
	public void saveProduct(Products product) throws ProductException {
		// TODO Auto-generated method stub
//		try {
//			transaction.begin();
//	        // Check if the category is detached and merge it
//	        Category category = product.getCategory();
//	        if (category != null) {
//	            category = em.merge(category);
//	            product.setCategory(category); // Reassign the managed category
//	        } 
//	        em.persist(product);
//	        transaction.commit();
//	        System.out.println("Product saved successfully.");
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
		try {
	        transaction.begin();

	        // Merge the category if detached
	        Category category = product.getCategory();
	        if (category != null && !em.contains(category)) {
	            category = em.merge(category);
	            product.setCategory(category);
	        }

	        // Merge the product if detached
	        if (!em.contains(product)) {
	            product = em.merge(product);
	        }

	        em.persist(product);
	        transaction.commit();
	        System.out.println("Product saved successfully.");

	    } catch (Exception e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
		
	}

	@Override
	public Products getProductById(int productId) throws ProductException {
		// TODO Auto-generated method stub
		Products product = null;
        try {
            product = em.find(Products.class, productId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return product;
	}

	@Override
	public void updateProduct(Products product) throws ProductException {
		// TODO Auto-generated method stub
		try {
            transaction.begin();
            em.merge(product);
            transaction.commit();
            System.out.println("Product updated successfully.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
		
	}

	@Override
	public void deleteProduct(int productId) throws ProductException {
		// TODO Auto-generated method stub
		try {
	        transaction.begin();
	        Products product = em.find(Products.class, productId);
	        if (product != null) {
	            // Detach the product from its category before removing
	            product.setCategory(null);
	            em.remove(product);
	            transaction.commit();
	            System.out.println("Product deleted successfully.");
	        }
	    } catch (Exception e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }		
	}

	@Override
	public List<Products> getProductsByCategory(int categoryId) throws ProductException {
		// TODO Auto-generated method stub
		List<Products> products = null;
        try {
            TypedQuery<Products> query = em.createQuery("FROM Products WHERE category.categoryId = :categoryId", Products.class);
            query.setParameter("categoryId", categoryId);
            products = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return products;
	}

	@Override
	public List<Products> getProductsByName(String productName) throws ProductException {
		// TODO Auto-generated method stub
		List<Products> products = null;
        try {
            TypedQuery<Products> query = em.createQuery("FROM Products WHERE name = :productName", Products.class);
            query.setParameter("productName", productName);
            products = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return products;
	}

	@Override
	public List<Products> getAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		List<Products> products = null;
        try {
            TypedQuery<Products> query = em.createQuery("FROM Products", Products.class);
            products = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        //products.forEach(System.out::println) ;
        return products;
	}
	
	public static void main(String[] args) {
		ProductDao dao = new ProductDaoImpl();
        Products p1 = new Products(7, "Doms Crayons", "Discover the joy of vibrant", 50.00, 10, new Category(6, "Art Supplies"));
 		 
		try {
			 dao.saveProduct(p1);
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//listOfStudent.forEach(System.out::println) ;

}
