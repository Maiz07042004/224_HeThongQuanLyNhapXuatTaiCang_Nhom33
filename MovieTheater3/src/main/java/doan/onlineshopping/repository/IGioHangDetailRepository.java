/*	
*	(C) Copyright 2024 Fresher56. All Rights Reserved
*
* @author ADMIN
* @date May 13, 2024
 
*/

package doan.onlineshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import doan.onlineshopping.entity.Category;
import doan.onlineshopping.entity.GioHang;
import doan.onlineshopping.entity.GioHangDetail;
import doan.onlineshopping.entity.GioHangID;
import doan.onlineshopping.entity.Product;

public interface IGioHangDetailRepository extends JpaRepository<GioHangDetail, GioHangID> {

	@Query(value = "SELECT * FROM GioHang_Detail INNER JOIN Product ON Product.product_id = GioHang_Detail.ProductID WHERE GioHang_Detail.account_ID =?1 ", nativeQuery = true)
	public List<GioHangDetail> findProductByAccountID(String accountID);

	
	@Query(value = "DELETE FROM GioHang_Detail WHERE ProductID = ?1", nativeQuery = true)
	public void deleteGioHangbyProductID(int id);
	
	@Transactional
	@Modifying    
	@Query(value = "UPDATE GioHang_Detail SET quantity =?3 WHERE ProductID =?1 AND account_ID=?2", nativeQuery = true)
	public void updateQuantity(int productID, String accountID, int quantity);
}
