package com.niit.entertainment_backend.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="SupplierDetails",uniqueConstraints = {
		@UniqueConstraint(columnNames = "supplier_Id")})
public class Suppliermodel implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue
  @Column(name="supplier_Id")
  private int supplierId;
  @Column(name="supplier_Name")
  private String supplierName;
  @Column(name="supplier_products")
  @OneToMany(targetEntity=Telemodel.class, fetch = FetchType.LAZY, mappedBy = "prodSupplier", cascade=CascadeType.ALL)
  private Set<Telemodel> supplierproducts=new HashSet<Telemodel>(0);
  
  
  
 
public Suppliermodel() {
	super();
}

public Suppliermodel(int supplierId, String supplierName) {
	super();
	this.supplierId = supplierId;
	this.supplierName = supplierName;
}

/*public Suppliermodel(String supplierId, String supplierName, Set<Telemodel> supplierproducts) {
	super();
	this.supplierId = supplierId;
	this.supplierName = supplierName;
	this.supplierproducts = supplierproducts;
}*/

public int getSupplierId() {
	return supplierId;
}

public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}

public String getSupplierName() {
	return supplierName;
}

public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}

public Set<Telemodel> getSupplierproducts() {
	return supplierproducts;
}

public void setSupplierproducts(Set<Telemodel> supplierproducts) {
	this.supplierproducts = supplierproducts;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}
  
}
