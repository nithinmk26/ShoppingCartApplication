/**
 * 
 */
package com.mindtree.cart.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author M1056182
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

	private int productId;

	private String productName;

	private float price;

	@JsonInclude(Include.NON_NULL)
	private String genre;
	
	@JsonInclude(Include.NON_NULL)
	private String author;

	@JsonInclude(Include.NON_NULL)
	private String publication;

	@JsonInclude(Include.NON_NULL)
	private String type;

	@JsonInclude(Include.NON_NULL)
	private String brand;

	@JsonInclude(Include.NON_NULL)
	private String design;


	

}
