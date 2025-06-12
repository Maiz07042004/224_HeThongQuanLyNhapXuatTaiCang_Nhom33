/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Account")
@SQLDelete(sql = "update Account set delete_flag = 1 where account_id = ?")
@Where(clause = "delete_flag <> 1")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "account_id", length = 10)
	private String accountID;

	@Column(name = "address", length = 255)
	private String address;

	@Column(name = "date_of_birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	@Column(name = "email", length = 255)
	private String email;

	@Column(name = "full_name", length = 255)
	private String fullName;

	@Column(name = "gender", length = 255)
	private String gender;

	@Column(name = "identity_card", length = 255)
	private String identityCard;

	@Column(name = "image", length = 255)
	private String image;

	@Column(name = "password", length = 255)
	private String password;

	@Column(name = "phone_number", length = 255)
	private String phoneNumber;

	@Column(name = "register_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registerDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleID")
	private Roles roles;

	@Column(name = "status")
	private int status;

	@Column(name = "user_name", length = 255, unique = true)
	private String userName;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Member> listMember;

	public Account() {
		super();
	}

	public Account(String accountID, String address, LocalDate dateOfBirth, String email, String fullName,
			String gender, String identityCard, String image, String password, String phoneNumber,
			LocalDate registerDate, Roles roles, int status, String userName, int deleteFlag) {
		super();
		this.accountID = accountID;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.fullName = fullName;
		this.gender = gender;
		this.identityCard = identityCard;
		this.image = image;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.registerDate = registerDate;
		this.roles = roles;
		this.status = status;
		this.userName = userName;
		this.deleteFlag = deleteFlag;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<Member> getListMember() {
		return listMember;
	}

	public void setListMember(List<Member> listMember) {
		this.listMember = listMember;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
