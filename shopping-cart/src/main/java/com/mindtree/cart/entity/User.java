/**
 * 
 */
package com.mindtree.cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author M1056182
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Comparable<User> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String name;

	private String address;
	
	private String email;
	
	@OneToOne
	Cart cart;

	
	
	@Override
	public int compareTo(User arg0) {
		if (userId > arg0.getUserId()) {
			return 1;
		} else if (userId < arg0.getUserId()) {
			return -1;
		} else {
			return 0;
		}
	}

}
