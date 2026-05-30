package Anudip.E_Commerce_App.dao;

import java.util.List;

import Anudip.E_Commerce_App.exception.UserException;
import Anudip.E_Commerce_App.model.Users;

public interface UserDao {
	// Save a new User
	public void saveUser(Users user) throws UserException;
	
	// Retrieve a User by ID
	public Users getUserById(int userId) throws UserException;
	
	// Update an existing User
	public void updateUser(Users user) throws UserException;
	
	// Delete a User by ID
	public void deleteUser(int userId) throws UserException;
	
	// Get list of all Users
	public List<Users> getAllUsers() throws UserException;
	
	// Retrieve a User by userName
	public Users getUserByUserName(String userName) throws UserException;
}
