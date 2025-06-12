/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.Member;

public interface IMemberService {
	public List<Member> getListMovie();

	public Member getMovieById(String id);

	public void addOrEditMovie(Member member);

	public void deleteMovie(String id);

	Member getMemberByAccountId(String accountID);

	Member getMemberById(String memberID);
}
