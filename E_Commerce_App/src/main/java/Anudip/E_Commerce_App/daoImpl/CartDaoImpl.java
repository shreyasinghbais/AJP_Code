package Anudip.E_Commerce_App.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Anudip.E_Commerce_App.dao.CartDao;
import Anudip.E_Commerce_App.exception.CartException;
import Anudip.E_Commerce_App.exception.CartProductException;
import Anudip.E_Commerce_App.model.Cart;
import Anudip.E_Commerce_App.model.CartProduct; 
import Anudip.E_Commerce_App.utility.EmUtil;

public class CartDaoImpl implements CartDao{
	
	EntityManager em = EmUtil.provideEntityManager();
	EntityTransaction transaction = em.getTransaction();

	@Override
	public void saveCart(Cart cart) throws CartException {
		// TODO Auto-generated method stub
		try {
            transaction.begin();
            if (cart.getCartId() != 0) { 
	            em.merge(cart);
	        } else { 
	            em.persist(cart);
	        } 
            transaction.commit();
            System.out.println("Cart saved successfully.");
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
	public Cart getCartByUserId(int userId) throws CartException {
		// TODO Auto-generated method stub
		Cart cart = null;
        try {
            TypedQuery<Cart> query = em.createQuery("FROM Cart WHERE user.userId = :userId", Cart.class);
            query.setParameter("userId", userId);
            cart = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           em.close();
        }
        return cart;
	}

	@Override
	public void saveCartProduct(CartProduct cartProduct) throws CartProductException {
		// TODO Auto-generated method stub
		try {
            transaction.begin();
            if (cartProduct.getCartProductId() != 0) { 
	            em.merge(cartProduct);
	        } else { 
	            em.persist(cartProduct);
	        }
            //em.persist(cartProduct);
            transaction.commit();
            System.out.println("Product saved successfully in Cart.");
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
	public List<CartProduct> getCartProductsByCartId(int cartId) throws CartProductException {
		// TODO Auto-generated method stub
		List<CartProduct> cartProducts = null;
        try {
            TypedQuery<CartProduct> query = em.createQuery("FROM CartProduct WHERE cart.cartId = :cartId", CartProduct.class);
            query.setParameter("cartId", cartId);
            cartProducts = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        //cartProducts.forEach(System.out::println) ;
        return cartProducts;
	}

	@Override
	public void updateCart(Cart cart) throws CartException {
		// TODO Auto-generated method stub
		try {
            transaction.begin();
            em.merge(cart);
            transaction.commit();
            System.out.println("Cart updated successfully.");
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
	public void deleteCart(int cartId) throws CartException {
		// TODO Auto-generated method stub
		 try {
		        transaction.begin();
		        // Find the cart by ID
		        Cart cart = em.find(Cart.class, cartId);
		        
		        if (cart != null) {
		            // First, remove all associated products in cart_product table
		            Query query = em.createQuery("DELETE FROM CartProduct cp WHERE cp.cart.id = :cartId");
		            query.setParameter("cartId", cartId);
		            query.executeUpdate();      
		            // Now, remove the cart itself
		            em.remove(cart);
		            transaction.commit();
		            System.out.println("Cart and its associated products deleted successfully.");
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
	public List<Cart> getAllCarts() throws CartException {
		// TODO Auto-generated method stub
		List<Cart> carts = null;
        try {
            TypedQuery<Cart> query = em.createQuery("FROM Cart", Cart.class);
            carts = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        //carts.forEach(System.out::println) ;
        return carts;
	}

	@Override
	public List<CartProduct> getAllCartProducts() throws CartProductException {
		// TODO Auto-generated method stub
		List<CartProduct> cartProducts = null;
        try {
            TypedQuery<CartProduct> query = em.createQuery("FROM CartProduct", CartProduct.class);
            cartProducts = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        //cartProducts.forEach(System.out::println) ;
        return cartProducts;
	}
	
	public static void main(String[] args) { 
		CartDao dao = new CartDaoImpl();  
//		CartProduct cp = new CartProduct(2, new Cart(1, new Users(1, "Pia", "pia@abc", "MP", "1234567890")), 
//				new Products(5, "Lays Chips", "Cream & Onion", 10.00, 40, new Category(3, "Chips")), 5);
		try {   
			 //dao.saveCartProduct(cp);
			 dao.getAllCartProducts();
		} catch (CartProductException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}
}
