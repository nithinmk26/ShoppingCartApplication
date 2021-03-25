/**
 * 
 */
package com.digital.cart.entity;

import javax.persistence.Entity;

/**
 * @author M1056182
 *
 */
@Entity
public class Appearal extends Product{

	private String type;
	
	private String brand;
	
	private String design;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the design
	 */
	public String getDesign() {
		return design;
	}

	/**
	 * @param design the design to set
	 */
	public void setDesign(String design) {
		this.design = design;
	}

	/**
	 * @param type
	 * @param brand
	 * @param design
	 */
	public Appearal(String type, String brand, String design) {
		super();
		this.type = type;
		this.brand = brand;
		this.design = design;
	}

	/**
	 * 
	 */
	public Appearal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
