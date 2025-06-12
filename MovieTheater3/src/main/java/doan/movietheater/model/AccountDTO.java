/*	
*	(C) Copyright 2021 Fresher56. All Rights Reserved
*
* @author HCD-Fresher084
* @date Apr 16, 2021
* @ version 1.0
*/

package doan.movietheater.model;

import java.time.LocalDate;
import java.util.List;

import doan.movietheater.entity.Member;





public class AccountDTO {
	private String accountID;


	private String address;

	private String dateOfBirth;


	private String email;


	private String fullName;


	private String gender;


	private String identityCard;


	private String image;


	private String password;


	private String phoneNumber;


	private LocalDate registerDate;


	private int roleID;


	private int status;


	private String userName;


	private int deleteFlag;


	private List<Member> listMember;

	
	
	public AccountDTO() {

	}


	public AccountDTO(String accountID, String address, String dateOfBirth, String email, String fullName,
			String gender, String identityCard, String image, String password, String phoneNumber,
			LocalDate registerDate, int roleID, int status, String userName, int deleteFlag, List<Member> listMember) {
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
		this.roleID = roleID;
		this.status = status;
		this.userName = userName;
		this.deleteFlag = deleteFlag;
		this.listMember = listMember;
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


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
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


	public int getRoleID() {
		return roleID;
	}


	public void setRoleID(int roleID) {
		this.roleID = roleID;
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
	
	
}
