package Anudip.E_Commerce_App.dao;

import java.util.List;

import Anudip.E_Commerce_App.exception.ProductException;
import Anudip.E_Commerce_App.model.Products;

public interface ProductDao {
	// Save a new product to the database
    public void saveProduct(Products product) throws ProductException;
    
    // Get a product by its ID
    public Products getProductById(int productId) throws ProductException;
    
    // Update an existing product
    public void updateProduct(Products product) throws ProductException;
    
    // Delete a product by its ID
    public void deleteProduct(int productId) throws ProductException;
    
    // Get a list of products by their category ID
    public List<Products> getProductsByCategory(int categoryId) throws ProductException;
    
    // Get a list of products by their name
    public List<Products> getProductsByName(String productName) throws ProductException;
    
    // Get all products from the database
    public List<Products> getAllProducts() throws ProductException;
}
