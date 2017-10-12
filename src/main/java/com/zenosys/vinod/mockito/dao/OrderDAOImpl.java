/**
 * 
 */
package com.zenosys.vinod.mockito.dao;

import java.sql.SQLException;

import com.zenosys.vinod.mockito.model.Order;

/**
 * This class represents
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
public class OrderDAOImpl implements OrderDAO {

	private OrderDAO orderDAO;
	
	/* (non-Javadoc)
	 * @see com.zenosys.vinod.mockito.dao.OrderDAO#create(com.zenosys.vinod.mockito.model.Order)
	 */
	@Override
	public int create(Order order) throws SQLException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.zenosys.vinod.mockito.dao.OrderDAO#update(com.zenosys.vinod.mockito.model.Order)
	 */
	@Override
	public int update(Order order) throws SQLException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.zenosys.vinod.mockito.dao.OrderDAO#delete(int)
	 */
	@Override
	public int delete(int id) throws SQLException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.zenosys.vinod.mockito.dao.OrderDAO#findOderById(int)
	 */
	@Override
	public Order findOderById(int id) throws SQLException {
		return null;
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
