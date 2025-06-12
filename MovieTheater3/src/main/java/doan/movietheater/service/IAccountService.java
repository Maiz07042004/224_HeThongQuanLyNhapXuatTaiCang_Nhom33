/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.Account;

public interface IAccountService {
	public List<Account> getListAccount();

	public Account getMovieById(String id);

	public void addOrEditMovie(Account account);

	public void deleteMovie(String id);

}
