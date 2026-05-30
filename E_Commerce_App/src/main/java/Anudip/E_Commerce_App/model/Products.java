package Anudip.E_Commerce_App.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
     
	private String name;
    private String description;
    private double price;
    private int stockQuantity;
     
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;

    //Getters & Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//Constructors
	public Products(int productId, String name, String description, double price, int stockQuantity,
			Category category) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.category = category;
	}
	public Products() {}

	//ToString
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", stockQuantity=" + stockQuantity + ", category=" + category + "]";
	};
	   
}
