/**
 * 
 */
package com.mindtree.cart.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ShopResponse {
	
	private String result;
	
	@JsonInclude(Include.NON_NULL)
	private Object object;
	
}
