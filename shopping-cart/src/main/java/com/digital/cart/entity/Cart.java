/**
 * 
 */
package com.digital.cart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author M1056182
 *
 */
@Entity
public class Cart implements Comparable<Cart> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	private double cartValue;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Product> productList;

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the cartValue
	 */
	public double getCartValue() {
		return cartValue;
	}

	/**
	 * @param cartValue the cartValue to set
	 */
	public void setCartValue(double cartValue) {
		this.cartValue = cartValue;
	}

	/**
	 * @return the productList
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


	/**
	 * @param cartId
	 * @param cartValue
	 * @param productList
	 */
	public Cart(int cartId, double cartValue, List<Product> productList) {
		super();
		this.cartId = cartId;
		this.cartValue = cartValue;
		this.productList = productList;
	}

	/**
	 * 
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Cart arg0) {
		if (cartId > arg0.getCartId()) {
			return 1;
		} else if (cartId < arg0.getCartId()) {
			return -1;
		} else {
			return 0;
		}
	}

}
