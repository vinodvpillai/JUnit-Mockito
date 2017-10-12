/**
 * 
 */
package com.zenosys.vinod.mockito.service;

import java.sql.SQLException;

import com.zenosys.vinod.mockito.dao.OrderDAO;
import com.zenosys.vinod.mockito.exception.BOException;
import com.zenosys.vinod.mockito.model.Order;

/**
 * This class represents OrderService Implementation
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version 1.0
 */
public class OrderServiceImpl implements OrderService {
	
	private OrderDAO orderDAO;

	/* (non-Javadoc)
	 * @see com.zenosys.vinod.mockito.service.OrderService#placeOrder(com.zenosys.vinod.mockito.model.Order)
	 */
	@Override
	public boolean placeOrder(Order order) throws BOException {
		
		try {
			if(getOrderDAO().create(order)==0)
				return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.zenosys.vinod.mockito.service.OrderService#cancelOrder(int)
	 */
	@Override
	public boolean cancelOrder(int id) throws BOException {
		
		Order order;
		try {
			order = getOrderDAO().findOderById(id);
			if(order==null)
				return false;
			order.setStatus("Cancel");
			if(getOrderDAO().update(order)==0){
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see com.zenosys.vinod.mockito.service.OrderService#deleteOrder(int)
	 */
	@Override
	public boolean deleteOrder(int id) throws BOException {
		
		try {
			if(getOrderDAO().delete(id)==0){
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	/**
	 * @return the orderDAO
	 */
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	/**
	 * @param orderDAO the orderDAO to set
	 */
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	
		
}
