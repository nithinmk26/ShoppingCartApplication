/**
 * 
 */
package com.digital.cart.contants;

/**
 * @author M1056182
 *
 */
public class ShoppingConstants {
	
	public static final String USER_NAME = "^[a-zA-Z_ -]{3,16}$";
	
	public static final String EMAIL = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
	
	public static final String USER_NAME_INVALID = "User Name is Invalid";
	
	public static final String EMAIL_INVALID = "Email is Invalid";
	
	public static final String PRODUCT_NOT_FOUND = "Product Not Found..!";
	
	public static final String USER_NOT_FOUND = "User Not Found..!";

	public static final String PRODUCT_UNAVAILABLE = "Out of Stock.!";
	
	public static final String PRODUCT_NOT_BELONGS = "Product Not there in User Cart.!";
	
	public static final String PRODUCT_QUANTITY_NOT_IN_RANGE = "Product Quantity should not be Negative Value.!";
}
