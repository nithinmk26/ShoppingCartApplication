/**
 * 
 */
package com.mindtree.cart.entity;

import javax.persistence.Entity;

/**
 * @author M1056182
 *
 */
@Entity
public class Books extends Product{

	private String genre;
	
	private String author;
	
	private String publication;

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publication
	 */
	public String getPublication() {
		return publication;
	}

	/**
	 * @param publication the publication to set
	 */
	public void setPublication(String publication) {
		this.publication = publication;
	}

	/**
	 * @param genre
	 * @param author
	 * @param publication
	 */
	public Books(String genre, String author, String publication) {
		super();
		this.genre = genre;
		this.author = author;
		this.publication = publication;
	}

	/**
	 * 
	 */
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
