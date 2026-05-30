package Anudip.E_Commerce_App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

	//Getters & Setters
    public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	//Constructors
	public Cart(int cartId, Users user) {
		super();
		this.cartId = cartId;
		this.user = user;
	}
	public Cart() {}
 
	//ToString
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + "]";
	}; 
}
