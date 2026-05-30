package Anudip.E_Commerce_App.dao;

import java.util.List;

import Anudip.E_Commerce_App.exception.OrderItemException;
import Anudip.E_Commerce_App.exception.OrdersException;
import Anudip.E_Commerce_App.model.OrderItem;
import Anudip.E_Commerce_App.model.Orders;

public interface OrderDao {
	// Save a new Order to the database
    public void saveOrder(Orders order) throws OrdersException;
    
    // Save a new OrderItem to the database
    public void saveOrderItem(OrderItem orderItem) throws OrderItemException;
    
    // Get an Order by its ID
    public Orders getOrderById(int orderId) throws OrdersException;
    
    // Get an OrderItem by its ID
    public OrderItem getOrderItemById(int orderItemId) throws OrderItemException;
    
    // Update an existing Order
    public void updateOrder(Orders order) throws OrdersException;
    
    // Update an existing OrderItem
    public void updateOrderItem(OrderItem orderItem) throws OrderItemException;
    
    // Delete an Order by its ID
    public void deleteOrder(int orderId) throws OrdersException;
    
    // Delete an OrderItem by its ID
    public void deleteOrderItem(int orderItemId) throws OrderItemException;
    
    // Get a list of all Orders
    public List<Orders> getAllOrders() throws OrdersException;
    
    // Get a list of all OrderItems for a specific order
    public List<OrderItem> getOrderItemsByOrderId(int orderId) throws OrderItemException;
}
