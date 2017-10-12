/**
 * 
 */
package com.zenosys.vinod.mockito.service;

import com.zenosys.vinod.mockito.exception.BOException;
import com.zenosys.vinod.mockito.model.Order;

/**
 * This Interface OrderService 
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
public interface OrderService {

	public boolean placeOrder(Order order) throws BOException;
	public boolean cancelOrder(int id) throws BOException;
	public boolean deleteOrder(int id) throws BOException;
}
