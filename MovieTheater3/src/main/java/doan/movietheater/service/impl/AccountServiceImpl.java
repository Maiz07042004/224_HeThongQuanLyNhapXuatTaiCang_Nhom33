/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import doan.movietheater.entity.Account;
import doan.movietheater.repository.IAccountRepository;
import doan.movietheater.service.IAccountService;
@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccountRepository accountRepository;

	@Override
	public List<Account> getListAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account getMovieById(String id) {
		return accountRepository.findOne(id);
	}

	@Override
	public void addOrEditMovie(Account account) {
		accountRepository.save(account);
	}

	@Override
	public void deleteMovie(String id) {
		accountRepository.delete(id);
	}

	/**
	 * The function retrieves customer information by identity card number
	 */
	public Account getAccountByPhoneNumber(String phoneNumber) {
		return accountRepository.getAccountByPhoneNumber(phoneNumber);
	}
	
	public Account getAccountByUserName(String username) {
		return accountRepository.findAcountByUserName(username);
	}
	
	public List<Account> getListCustomer(){
		return accountRepository.getListCustomer();
	}
	
	public List<Account> getListNV(){
		return accountRepository.getListNV();
	}
}
