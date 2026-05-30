package Anudip.E_Commerce_App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_product")
public class CartProduct {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartProductId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    private int quantity;

	//Getters & Setters
    public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//Constructors
	public CartProduct(int cartProductId, Cart cart, Products product, int quantity) {
		super();
		this.cartProductId = cartProductId;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}
	public CartProduct() {}

	//ToString
	@Override
	public String toString() {
		return "CartProduct [cartProductId=" + cartProductId + ", cart=" + cart + ", product=" + product + ", quantity="
				+ quantity + "]";
	};
}
