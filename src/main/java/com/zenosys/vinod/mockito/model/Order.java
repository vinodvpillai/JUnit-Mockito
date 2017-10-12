/**
 * 
 */
package com.zenosys.vinod.mockito.model;

/**
 * This Order represents - Model Class for all Order operation
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version 1.0
 */
public class Order {

	private int id;
	private String status;

	/**
	 * Constructor - id & status are final variable
	 * 
	 * @param id
	 * @param status
	 */
	public Order(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Order() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

}
