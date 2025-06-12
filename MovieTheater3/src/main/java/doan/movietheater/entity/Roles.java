/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Roles")
@SQLDelete(sql = "update Roles set delete_flag = 1 where role_id = ?")
@Where(clause = "delete_flag <> 1")
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleID;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@OneToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<Account> listAccount;

	public Roles() {
		super();
	}

	public Roles(int roleID, String roleName, int deleteFlag) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.deleteFlag = deleteFlag;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
