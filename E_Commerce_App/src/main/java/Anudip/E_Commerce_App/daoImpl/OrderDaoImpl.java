package Anudip.E_Commerce_App.daoImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Anudip.E_Commerce_App.dao.CartDao;
import Anudip.E_Commerce_App.dao.OrderDao;
import Anudip.E_Commerce_App.exception.OrdersException;
import Anudip.E_Commerce_App.model.OrderItem;
import Anudip.E_Commerce_App.model.Orders;
import Anudip.E_Commerce_App.model.Users;
import Anudip.E_Commerce_App.utility.EmUtil;

public class OrderDaoImpl implements OrderDao{
	
	EntityManager em = EmUtil.provideEntityManager();
	EntityTransaction transaction = em.getTransaction();
	
	@Override
	public void saveOrder(Orders order) {
		// TODO Auto-generated method stub
		try {
	        transaction.begin();
	        // Use merge instead of persist to reattach the detached entity
	        em.merge(order);
	        transaction.commit();
	        System.out.println("Order saved successfully.");
	    } catch (Exception e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	}

	@Override
	public void saveOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orders getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem getOrderItemById(int orderItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(Orders order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> getOrderItemsByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		OrderDao dao = new OrderDaoImpl();  
		Orders o1 = new Orders(1, new Users(1, "Pia", "pia@abc", "MP", "1234567890"), new Date(), "COD");
		try {
			dao.saveOrder(o1);
		} catch (OrdersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
