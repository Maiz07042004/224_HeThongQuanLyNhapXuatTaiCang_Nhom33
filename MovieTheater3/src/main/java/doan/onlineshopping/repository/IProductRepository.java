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

import doan.onlineshopping.entity.Product;


@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>  {
	@Query(value = "SELECT * FROM Product WHERE product_name = ?1 and delete_flag = 0", nativeQuery = true)
	public Product getProductByProductName(String productName);
	
	@Query(value = "SELECT * FROM Product INNER JOIN GioHang_Detail ON Product.product_id = GioHang_Detail.ProductID WHERE GioHang_Detail.account_ID =?1", nativeQuery = true)
	public List<Product> findProductByGioHangDetail(String accountID);
	
	
	@Transactional
	@Modifying    
	@Query(value = "UPDATE Product SET quantity =?1 WHERE product_id =?2", nativeQuery = true)
	public void updateQuantity(int sl, int productid);
	
	@Query(value = "SELECT * FROM Product WHERE category_id = ?1 and delete_flag = 0", nativeQuery = true)
	public List<Product> getProductByCategoryID(int id);
	
	@Query(value = "SELECT * FROM Product WHERE sellerID = ?1 and delete_flag = 0", nativeQuery = true)
	public List<Product> getProductBySellerID(String id);
}
