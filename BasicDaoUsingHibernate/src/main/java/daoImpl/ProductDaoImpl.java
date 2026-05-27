package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dao.ProducctDao;
import exception.ProductException;
import model.Product;
import utility.EmUtil;

public class ProductDaoImpl implements ProducctDao{

	@Override
	public boolean addProduct(Product p) throws ProductException {
		boolean ans = false;
		EntityManager em = EmUtil.provideEntityManager();
		em.getTransaction().begin();
		//em.persist(p);
		if (p.getProductId() == null) {
	        // This is a new entity, use persist
	        em.persist(p);
	    } else {
	        // This is a detached entity, use merge
	        em.merge(p);
	    }
		ans = true;
		em.getTransaction().commit();
		em.close();
		return ans;
	}

	@Override
	public boolean deleteProduct(int pId) throws ProductException {
		boolean ans = false;
		EntityManager em = EmUtil.provideEntityManager();
		Product p = em.find(Product.class, pId);
		if(p!=null) {
			em.getTransaction().begin();
			em.remove(p);
			ans = true;
			em.getTransaction().commit();
			em.close();
		} else {
			throw new ProductException("product not found" );
		}
		return ans;
	}

	@Override
	public boolean updateProduct(Product p) throws ProductException {
		boolean ans  = false   ;
		EntityManager em = EmUtil.provideEntityManager() ;
		em.getTransaction().begin();     
		em.merge(p);
		ans = true ;
		em.getTransaction().commit(); 
		em.close();		
		return ans ;
	}

	@Override
	public List<Product> findAllProduct() throws ProductException {
		EntityManager em = EmUtil.provideEntityManager() ;
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Product> cq = cb.createQuery(Product.class);	    
		Root<Product> rootEntry = cq.from(Product.class);	    
		CriteriaQuery<Product> all = cq.select(rootEntry);
	    TypedQuery<Product> allQuery = em.createQuery(all);	    
		return allQuery.getResultList();
	}

	@Override
	public Product findSingleProduct(int pId) throws ProductException {
		//boolean ans  = false;
		EntityManager em = EmUtil.provideEntityManager() ;
		Product p  = em.find(Product.class, pId);
		return p;
	}

}
