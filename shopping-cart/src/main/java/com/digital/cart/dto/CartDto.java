/**
 * 
 */
package com.digital.cart.dto;

import java.util.List;

import com.digital.cart.entity.Product;

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
public class CartDto {
	
	private int cartId;
	
	private double cartValue;
	
	private List<Product> productList;
	

}
