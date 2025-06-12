/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import doan.movietheater.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {

	@Query(value = "SELECT * FROM Account WHERE phone_number = ?1 and delete_flag = 0", nativeQuery = true)
	Account getAccountByPhoneNumber(String phoneNumber);
	
	public Account findAcountByUserName(String username);
	
	@Query(value = "SELECT * FROM Account WHERE roleID = 3 and delete_flag=0", nativeQuery = true)
	public List<Account> getListCustomer();
	
	@Query(value = "SELECT * FROM Account WHERE (roleID = 1 or roleID=2) and delete_flag = 0", nativeQuery = true)
	public List<Account> getListNV();
}
