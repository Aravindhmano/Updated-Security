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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
/*@Table(name="UserDetails",uniqueConstraints = {
		@UniqueConstraint(columnNames = "user_Id"),
		@UniqueConstraint(columnNames = "userMailId") })*/
@Table(name="Usermodel")
public class Usermodel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="userNumId")
	@GeneratedValue
	private int userNumId;
	
	@Column(name="u_mail")
	private String u_mail;
	
	@Column(name="userName")
	private String userName;
	@Column(name="userAge")
	private int userAge;
	@Column(name="userPassword")
	private String userPassword;
	@Column(name="userPhno")
	private String userPhno;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cart")
	private Cartmodel cart;
	/*@Column(name="user_Orders")*/
	@OneToMany(mappedBy="userId",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Ordersmodel> orders;
	@Column(name="userRole")
	private String userRole;
	@Column(name="enabled")
	private boolean enabled;
	
	public Usermodel()
	{
		super();
	}

	public Usermodel(int userNumId, String userName, int userAge, String userPassword, String userPhno,
			Cartmodel cart, Set<Ordersmodel> orders, String userRole, boolean enabled) {
		super();
		this.userNumId = userNumId;
		this.userName = userName;
		this.userAge = userAge;
		this.userPassword = userPassword;
		this.userPhno = userPhno;
		this.cart = cart;
		this.orders = orders;
		this.userRole = userRole;
		this.enabled = enabled;
	}

	public int getUserNumId() {
		return userNumId;
	}

	public void setUserNumId(int userNumId) {
		this.userNumId = userNumId;
	}

	

	public String getU_mail() {
		return u_mail;
	}

	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhno() {
		return userPhno;
	}

	public void setUserPhno(String userPhno) {
		this.userPhno = userPhno;
	}

	public Cartmodel getCart() {
		return cart;
	}

	public void setCart(Cartmodel cart) {
		this.cart = cart;
	}

	public Set<Ordersmodel> getOrders() {
		return orders;
	}

	public void setOrders(Set<Ordersmodel> orders) {
		this.orders = orders;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	}
