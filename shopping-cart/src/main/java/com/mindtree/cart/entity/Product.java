/**
 * 
 */
package com.mindtree.cart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author M1056182
 *
 */
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "product.findByProductName", query = "select p from Product p where p.productName=?"),
	@NamedNativeQuery(name = "product.findByProductType", query = "select p from Product p where p.category=?"),
})
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"quantity"})
public class Product implements Comparable<Product> {

	@Id
	private int productId;

	private String productName;

	private float price;

	@Column(nullable = true, columnDefinition = "integer default 0")
	private int quantity = 0;   
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonBackReference
	private Cart cart;
  
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}



	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * @param productId
	 * @param productName
	 * @param price
	 * @param quantity
	 */
	public Product(int productId, String productName, float price, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Product arg0) {
		if (productId > arg0.getProductId()) {
			return 1;
		} else if (productId < arg0.getProductId()) {
			return -1;
		} else {
			return 0;
		}
	}

}
