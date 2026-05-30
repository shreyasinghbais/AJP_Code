package Anudip.E_Commerce_App.dao;

import java.util.List;

import Anudip.E_Commerce_App.exception.CategoryException;
import Anudip.E_Commerce_App.model.Category;

public interface CategoryDao {
	// Save a new Category to the database
    public void saveCategory(Category category) throws CategoryException;
    
    // Get a Category by its ID
    public Category getCategoryById(int categoryId) throws CategoryException;
    
    // Update an existing Category
    public void updateCategory(Category category) throws CategoryException;
    
    // Delete a Category by its ID
    public void deleteCategory(int categoryId) throws CategoryException;
    
    // Retrieve all Categories
    public List<Category> getAllCategories() throws CategoryException;
}
