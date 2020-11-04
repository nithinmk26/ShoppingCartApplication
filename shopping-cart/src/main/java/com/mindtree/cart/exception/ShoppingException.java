/**
 * 
 */
package com.mindtree.cart.exception;

/**
 * @author M1056182
 *
 */
public class ShoppingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4570797603076308630L;

	/**
	 * 
	 */
	public ShoppingException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public ShoppingException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ShoppingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ShoppingException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ShoppingException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
