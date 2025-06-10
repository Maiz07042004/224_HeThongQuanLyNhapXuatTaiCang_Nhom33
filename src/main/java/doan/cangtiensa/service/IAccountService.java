/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.cangtiensa.service;

import java.util.List;

import doan.cangtiensa.entity.Account;

public interface IAccountService {
	public List<Account> getListAccount();

	public Account getAccountById(String id);


	public void deleteMovie(String id);
	
	public void getOtp(String customerEmail, int otp);

	public void addOrEditAccount(Account account);

	public void deleteAccount(String userName);
	
	

}
