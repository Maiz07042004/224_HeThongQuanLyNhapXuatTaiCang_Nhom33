/*	
*	(C) Copyright 2024 Fresher56. All Rights Reserved
*
* @author ADMIN
* @date May 12, 2024
 
*/

package doan.onlineshopping.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Product")
@Where(clause = "delete_flag <> 1")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_id", length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "category_id")
	private Category categoryID ;

	@Nationalized
	@Column(name = "product_name", length = 255)
	private String productName;

	@Column(name = "price")
	private int price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "delete_flag")
	private int deleteFlag;
	
	@Column(name = "large_image", length = 255)
	private String largeImage;


	@Column(name = "small_image", length = 255)
	private String smallImage;
	
	@Column(name = "sellerID", length = 255)
	private String sellerID;
	

	public Product() {
		super();
	}


	public Product(int productID, Category categoryID, String productName, int price, int quantity, int deleteFlag,
			String largeImage, String smallImage, String sellerID) {
		super();
		this.productID = productID;
		this.categoryID = categoryID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.deleteFlag = deleteFlag;
		this.largeImage = largeImage;
		this.smallImage = smallImage;
		this.sellerID = sellerID;
	}


	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}


	public Category getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getDeleteFlag() {
		return deleteFlag;
	}


	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	public String getLargeImage() {
		return largeImage;
	}


	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}


	public String getSmallImage() {
		return smallImage;
	}


	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}


	public String getSellerID() {
		return sellerID;
	}


	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	}