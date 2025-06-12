/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import doan.movietheater.entity.Member;

@Repository
public interface IMemberRepository extends JpaRepository<Member, String> {

	@Query(value = "SELECT * FROM Member WHERE accountID = ?1", nativeQuery = true)
	Member getMemberByAccountId(String accountID);

	@Query(value = "SELECT * FROM Member WHERE member_id = ?1", nativeQuery = true)
	Member getMemberById(String memberID);

}
