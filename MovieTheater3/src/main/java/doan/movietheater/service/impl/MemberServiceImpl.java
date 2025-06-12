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

import doan.movietheater.entity.Member;
import doan.movietheater.repository.IMemberRepository;
import doan.movietheater.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	IMemberRepository memberRepository;

	@Override
	public List<Member> getListMovie() {
		return memberRepository.findAll();
	}

	@Override
	public Member getMovieById(String id) {
		return memberRepository.findOne(id);
	}

	@Override
	public void addOrEditMovie(Member member) {
		memberRepository.save(member);
	}

	@Override
	public void deleteMovie(String id) {
		memberRepository.delete(id);
	}

	/**
	 * The function obtains member information by account id
	 */
	@Override
	public Member getMemberByAccountId(String accountID) {
		return memberRepository.getMemberByAccountId(accountID);
	}

	/**
	 * The function obtains member information by member id
	 */
	@Override
	public Member getMemberById(String memberID) {
		return memberRepository.getMemberById(memberID);
	}

}
