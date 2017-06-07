package com.niit.entertainment_backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CartDetails",uniqueConstraints = {
		@UniqueConstraint(columnNames = "cartid")})
public class Cartmodel implements Serializable
{
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
	@Id
	@Column(name="cart_Id")
	private Integer cartId;
	@Column(name="cart_Supplier_Id")
	private Integer cartSupplierId;
	@Column(name="cart_Product_Id")
	private Integer cartProductId;
	@OneToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="UserId")
	private Usermodel cartUserDetails;
	@Column(name="cart_Price")
	private int cartPrice;
	@Column(name="cart_Quantity")
	private int cartQuantity;
	@Column(name="cart_Status")
	private String cartStatus;
	*/
private static final long serialVersionUID = 1L;
	
	@Id
     private int cartid;
	//private int suplierid;
	//private int productid;
	//private int userid;
	private Telemodel productid;
	private Suppliermodel suplierid;
	private Usermodel userid;
	
	private int prices;
	private int quantity;
	private String status;
	
	@Id
	@GeneratedValue
	@Column(name="cartid")//defining the database column
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	//In One productid display in cart
		@OneToOne
		@JoinColumn(name="prod_Id")
		public Telemodel getProductid() {
			return productid;
		}
		public void setProductid(Telemodel productid) {
			this.productid = productid;
		}
		/*@OneToOne
		@JoinColumn(name="suplierid")
		public SupplierModel getSuplierid() {
			return suplierid;
		}
		public void setSuplierid(SupplierModel suplierid) {
			this.suplierid = suplierid;
		}*/
		/*@OneToOne
		@JoinColumn(name="userid")
		public UserModel getUserid() {
			return userid;
		}
		public void setUserid(UserModel userid) {
			this.userid = userid;
		}*/
	@Column(name="prices")
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/*@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/
	
}