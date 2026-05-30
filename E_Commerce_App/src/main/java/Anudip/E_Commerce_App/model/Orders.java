package Anudip.E_Commerce_App.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private Date orderDate;
    private String status;
	
    // Getters and Setters
    public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	//Constructors
	public Orders(int orderId, Users user, Date orderDate, String status) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.orderDate = orderDate;
		this.status = status;
	} 
	public Orders() {};
	
	//ToString
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", user=" + user + ", orderDate=" + orderDate + ", status=" + status
				+ "]";
	}; 
}
