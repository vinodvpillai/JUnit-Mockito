/**
 * 
 */
package com.zenosys.vinod.mockito.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.zenosys.vinod.mockito.dao.OrderDAO;
import com.zenosys.vinod.mockito.exception.BOException;
import com.zenosys.vinod.mockito.model.Order;

/**
 * This class represents test class for OrderServiceImpl
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
public class OrderServiceImplTest {
	private static final int IN_VALID_ID = 100;
	private static final int VALID_ID = 1;

	@Mock
	OrderDAO orderDAO;

	OrderServiceImpl orderServiceImpl;

	/**
	 * This will tell Mockito to Scan this class if it find any @Mock annotation
	 * do necessary dependency injection
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		orderServiceImpl = new OrderServiceImpl();
		orderServiceImpl.setOrderDAO(orderDAO);
	}

	@Test
	public void place_Order_Should_Create_Order() throws SQLException {
		// Now when we call orderServiceImpl.placeOrder(order) =>
		// orderDAO.create it will always return 1 only
		Order order = new Order();
		when(orderDAO.create(order)).thenReturn(new Integer(1));
		assertTrue(orderServiceImpl.placeOrder(order));
		// To Check the method is called atleast once
		verify(orderDAO).create(order);

		// We can even verify how many time the create method is called when we
		// placeOrder valid is 1 once only.
		verify(orderDAO, times(1)).create(order);
		
		//atLeastOnce, atLeast(No.)
		verify(orderDAO,atLeastOnce()).create(order);
	}

	@Test
	public void place_Order_Should_Not_Create_Order() throws SQLException {
		Order order = new Order();
		when(orderDAO.create(order)).thenReturn(new Integer(0));
		assertFalse(orderServiceImpl.placeOrder(order));
	}

	@Test(expected = BOException.class)
	public void place_Order_Then_Throw_BOException() throws SQLException,
			BOException {
		Order order = new Order();
		when(orderDAO.create(order)).thenThrow(SQLException.class);
		orderServiceImpl.placeOrder(order);
	}

	@Test
	public void cancel_Order_Should_Cancel_Order() throws SQLException {
		Order order = new Order();
		when(orderDAO.findOderById(anyInt())).thenReturn(order);
		when(orderDAO.update(order)).thenReturn(new Integer(1));
		assertTrue(orderServiceImpl.cancelOrder(anyInt()));
		
		//Instead of giving the VALID_ID we can give any ID using Mockito Matchers Class
		//assertTrue(orderServiceImpl.cancelOrder(anyInt()));
		//For object => any(Order.class)
	}

	@Test
	public void cancel_Order_Invalid_ID_Order_Not_Cancel() throws SQLException {
		when(orderDAO.findOderById(IN_VALID_ID)).thenReturn(null);
		assertFalse(orderServiceImpl.cancelOrder(IN_VALID_ID));
	}

	@Test
	public void cance_Order_Should_Not_Cancel_Order() throws SQLException {
		Order order = new Order();
		when(orderDAO.findOderById(VALID_ID)).thenReturn(order);
		when(orderDAO.update(order)).thenReturn(new Integer(0));
		assertFalse(orderServiceImpl.cancelOrder(VALID_ID));
	}

	@Test(expected = BOException.class)
	public void cancel_Order_Find_Id_Problem_Then_Throw_BOException()
			throws SQLException {
		when(orderDAO.findOderById(VALID_ID)).thenThrow(SQLException.class);
		orderServiceImpl.cancelOrder(VALID_ID);
	}

	@Test(expected = BOException.class)
	public void cancel_Order_Update_Method_Problem_Then_Throw_BOException()
			throws SQLException, BOException {
		Order order = new Order();
		when(orderDAO.findOderById(VALID_ID)).thenReturn(order);
		when(orderDAO.update(order)).thenThrow(SQLException.class);
		orderServiceImpl.cancelOrder(VALID_ID);
	}

	@Test
	public void delete_Order_Should_Delete_Order() throws SQLException {
		when(orderDAO.delete(VALID_ID)).thenReturn(new Integer(1));
		assertTrue(orderServiceImpl.deleteOrder(VALID_ID));
	}

	@Test
	public void delete_Order_Should_Not_Delete_Order() throws SQLException {
		when(orderDAO.delete(IN_VALID_ID)).thenReturn(new Integer(0));
		assertFalse(orderServiceImpl.deleteOrder(IN_VALID_ID));
	}

	@Test(expected = BOException.class)
	public void delete_Order_Problem_BOException_Thrown() throws SQLException {

		when(orderDAO.delete(VALID_ID)).thenThrow(SQLException.class);
		orderServiceImpl.deleteOrder(VALID_ID);
	}

}
