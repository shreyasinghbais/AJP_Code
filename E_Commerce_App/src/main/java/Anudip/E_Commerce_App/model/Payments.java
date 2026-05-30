package Anudip.E_Commerce_App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int paymentId;

	 @ManyToOne
     @JoinColumn(name = "order_id")
     private Orders order;
	 
     private double amount;
     private String paymentType;
     private String paymentStatus;
	
    // Getters and Setters
    public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	//Constructors
	public Payments(int paymentId, Orders order, double amount, String paymentType, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.order = order;
		this.amount = amount;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
	}
	public Payments() {};
	
	//ToString
	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", order=" + order + ", amount=" + amount + ", paymentType="
				+ paymentType + ", paymentStatus=" + paymentStatus + "]";
	};
}
