/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.onlineshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import doan.onlineshopping.entity.Account;
import doan.onlineshopping.entity.Invoice;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {

	@Query(value = "SELECT * FROM Account WHERE phone_number = ?1 and delete_flag = 0", nativeQuery = true)
	Account getAccountByPhoneNumber(String phoneNumber);
	
	public Account findAcountByUserName(String username);
	
	@Query(value = "SELECT * FROM Account WHERE roleID = 3 and delete_flag=0", nativeQuery = true)
	public List<Account> getListCustomer();
	
	@Query(value = "SELECT * FROM Account WHERE (roleID = 1 or roleID=2) and delete_flag = 0", nativeQuery = true)
	public List<Account> getListNV();
	
	@Query(value = "SELECT * FROM Account WHERE user_name = ?1 and delete_flag = 0", nativeQuery = true)
	public Account getAccountByUserName(String userName);
	
	@Query(value = "SELECT * FROM Account WHERE roleID = 3 and seller_approve_flag = 1", nativeQuery = true)
	public List<Account> getListApprovingSeller();
	
	@Query(value = "SELECT * FROM Account WHERE email = ?1 and delete_flag = 0", nativeQuery = true)
	Account getAccountByEmail(String email);
	
	@Transactional
	@Modifying    
	@Query(value = "UPDATE Account SET one_time_password = ?2 WHERE email = ?1", nativeQuery = true)
	public void updateOTP(String email, int OTP);
	
	@Transactional
	@Modifying    
	@Query(value = "UPDATE Account SET seller_approve_flag = 0 WHERE user_name = ?1", nativeQuery = true)
	public void updateListApprovingSeller(String userName);
	
	@Transactional
	@Modifying    
	@Query(value = "UPDATE Account SET password = ?2 WHERE email = ?1", nativeQuery = true)
	public void updatePassword(String email, String password);

	@Query(value = "SELECT * FROM Account WHERE roleID = 3 and delete_flag=0", nativeQuery = true)
	public List<Account> getListSeller();
	
	@Query(value = "SELECT * FROM Invoice WHERE seller_id = ?1", nativeQuery = true)
	public List<Invoice> getListBuyer(String id);

}
