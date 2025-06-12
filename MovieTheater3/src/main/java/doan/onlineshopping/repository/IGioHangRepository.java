/*	
*	(C) Copyright 2024 Fresher56. All Rights Reserved
*
* @author ADMIN
* @date May 13, 2024
 
*/

package doan.onlineshopping.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.onlineshopping.entity.Category;
import doan.onlineshopping.entity.GioHang;

public interface IGioHangRepository extends JpaRepository<GioHang, Integer>  {

	
	
}
