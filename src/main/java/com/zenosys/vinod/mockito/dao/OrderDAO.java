/**
 * 
 */
package com.zenosys.vinod.mockito.dao;

import java.sql.SQLException;

import com.zenosys.vinod.mockito.model.Order;

/**
 * This Interface represents OrderDAO
 * All the Order methods will be declared here
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
public interface OrderDAO {

	int create(Order order) throws SQLException;
	int update(Order order) throws SQLException;
	int delete(int id) throws SQLException;
	Order findOderById(int id) throws SQLException;
	//List<Order> findAll();
}
