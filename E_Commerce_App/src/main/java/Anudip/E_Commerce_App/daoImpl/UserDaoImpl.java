package Anudip.E_Commerce_App.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Anudip.E_Commerce_App.dao.UserDao;
import Anudip.E_Commerce_App.exception.UserException;
import Anudip.E_Commerce_App.model.Users;
import Anudip.E_Commerce_App.utility.EmUtil;
 

public class UserDaoImpl implements UserDao{
	
	EntityManager em = EmUtil.provideEntityManager();
	EntityTransaction transaction = em.getTransaction();

	@Override
	public void saveUser(Users user) {
		// TODO Auto-generated method stub
		try {
            transaction.begin();
            
            if (user.getUserId() != 0) { 
	            em.merge(user);
	        } else { 
	            em.persist(user);
	        }
            transaction.commit();
            System.out.println("User is saved successfully."); 
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
	public Users getUserById(int userId) {
		// TODO Auto-generated method stub
		Users user = null;
        try {
            user = em.find(Users.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return user;
	}

	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		try {
            transaction.begin();
            em.merge(user);
            transaction.commit();
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
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		try {
            transaction.begin();
            Users user = em.find(Users.class, userId);
            if (user != null) {
                em.remove(user);
                transaction.commit();
                System.out.println("User is deleted successfully.");
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
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		List<Users> users = null;
        try {
            TypedQuery<Users> query = em.createQuery("FROM Users", Users.class);
            users = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return users;
	}

	@Override
	public Users getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		Users user = null;
        try {
            TypedQuery<Users> query = em.createQuery("FROM Users WHERE name = :userName", Users.class);
            query.setParameter("userName", userName);
            user = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return user;
	}

	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl();
		Users u1 = new Users();
		//u1.setUserId(3);
		u1.setName("Nia");
		u1.setEmail("nia@ijk");
		u1.setPhoneNumber("2505325053");
		u1.setAddress("WB");
//		dao.updateUser(u1);
//		dao.deleteUser(3);
		try {
			 dao.saveUser(u1);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
