package Anudip.E_Commerce_App.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Anudip.E_Commerce_App.dao.CategoryDao;
import Anudip.E_Commerce_App.exception.CategoryException;
import Anudip.E_Commerce_App.model.Category;
import Anudip.E_Commerce_App.utility.EmUtil;

public class CategoryDaoImpl implements CategoryDao{
	
	EntityManager em = EmUtil.provideEntityManager();
	EntityTransaction transaction = em.getTransaction();

	@Override
	public void saveCategory(Category category) throws CategoryException {
		// TODO Auto-generated method stub
		try {
			transaction.begin(); 
			if (category.getCategoryId() != 0) { 
	            em.merge(category);
	        } else { 
	            em.persist(category);
	        }
	        transaction.commit();
	        System.out.println("Category saved successfully.");
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
	public Category getCategoryById(int categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		Category category = null;
		try {
            category = em.find(Category.class, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return category;
	}

	@Override
	public void updateCategory(Category category) throws CategoryException {
		// TODO Auto-generated method stub
		try {
            transaction.begin();
            em.merge(category);
            transaction.commit();
            System.out.println("Category updated successfully.");
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
	public void deleteCategory(int categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		try {
            transaction.begin();
            Category category = em.find(Category.class, categoryId);
            if (category != null) {
                em.remove(category);
                transaction.commit();
                System.out.println("Category deleted successfully.");
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
	public List<Category> getAllCategories() throws CategoryException {
		// TODO Auto-generated method stub
		List<Category> categories = null;
        try {
            categories = em.createQuery("FROM Category", Category.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        //categories.forEach(System.out::println) ;
        return categories;
	}
	
	public static void main(String[] args) {
		CategoryDao dao = new CategoryDaoImpl();
//		Category c1 = new Category();
//		c1.setCategoryId(5);
//		c1.setCategoryName("Biscuits");
		try {
			dao.getAllCategories();
		} catch (CategoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
