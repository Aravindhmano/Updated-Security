package com.niit.entertainment_backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ProductDetails")
public class Telemodel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="prod_Id")
	private int prodId;
	/*@Column(name="prod_Brand")
	private String prodBrand;*/ 
	@Column(name="prod_Name")
	private String prodName;
	@Column(name="prod_Description")
	private String prodDescription;
	@Column(name="prod_Price")
	private int prodPrice;
	/*@Column(name="prod_Quantity")
	private int prodQuantity;*/
	@ManyToOne
	@JoinColumn(name="category_Id")
	private Categorymodel prodCategory;
	@ManyToOne
	@JoinColumn(name="supplier_Id")
	private Suppliermodel prodSupplier;
	@Column(name="image") private String image;
	
	public Telemodel()
	{
		
	}
	

	

	public Telemodel(int prodId, String prodName, String prodDescription, int prodPrice, Categorymodel prodCategory,
			Suppliermodel prodSupplier, String image) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDescription = prodDescription;
		this.prodPrice = prodPrice;
		this.prodCategory = prodCategory;
		this.prodSupplier = prodSupplier;
		this.image = image;
	}




	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public Categorymodel getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(Categorymodel prodCategory) {
		this.prodCategory = prodCategory;
	}

	public Suppliermodel getProdSupplier() {
		return prodSupplier;
	}

	public void setProdSupplier(Suppliermodel prodSupplier) {
		this.prodSupplier = prodSupplier;
	}

		
	
}