package service;

import dao.CustomerDAO;
import model.Customer;

import java.sql.SQLException;

public class AuthService {
    private CustomerDAO customerDAO;

    public AuthService() {
        customerDAO = new CustomerDAO();
    }

    public Customer login(String username, String password) throws SQLException {
        Customer customer = customerDAO.getCustomerByUsername(username);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        } else {
            throw new SQLException("Invalid username or password");
        }
    }

    public void register(Customer customer) throws SQLException {
        customerDAO.addCustomer(customer);
    }
}


