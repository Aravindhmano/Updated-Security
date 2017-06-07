package com.niit.entertainment_backend.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CategoryDetails")
public class Categorymodel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="category_Id")
	private int categoryId;
	@Column(name="category_Name")
	private String categoryName;
	@OneToMany(targetEntity=Telemodel.class, mappedBy = "prodCategory",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@Column(name="category_Products")
	private Set<Telemodel> categoryProducts;/*=new HashSet<Telemodel>(0);*/

	public Categorymodel()
	{
		super();
	}

	public Categorymodel(int categoryId, String categoryName, Set<Telemodel> categoryProducts) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryProducts = categoryProducts;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Telemodel> getCategoryProducts() {
		return categoryProducts;
	}

	public void setCategoryProducts(Set<Telemodel> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}

	
	
	
}
