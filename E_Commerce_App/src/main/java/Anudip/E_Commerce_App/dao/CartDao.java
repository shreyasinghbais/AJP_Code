package Anudip.E_Commerce_App.dao;

import java.util.List;

import Anudip.E_Commerce_App.exception.CartException;
import Anudip.E_Commerce_App.exception.CartProductException;
import Anudip.E_Commerce_App.model.Cart;
import Anudip.E_Commerce_App.model.CartProduct;

public interface CartDao {
	// Save a new Cart to the database
    public void saveCart(Cart cart) throws CartException;
    
    // Get a Cart by user ID
    public Cart getCartByUserId(int userId) throws CartException;
    
    // Save a CartProduct
    public void saveCartProduct(CartProduct cartProduct) throws CartProductException;
    
    // Get a list of CartProducts by Cart ID
    public List<CartProduct> getCartProductsByCartId(int cartId) throws CartProductException;
    
    // Update an existing Cart
    public void updateCart(Cart cart) throws CartException;
    
    // Delete a Cart by its ID
    public void deleteCart(int cartId) throws CartException;
    
    // Retrieve all carts from the database
    public List<Cart> getAllCarts() throws CartException;
    
 // Retrieve all CartProducts from the database
    public List<CartProduct> getAllCartProducts() throws CartProductException;
}
