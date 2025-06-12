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
import doan.onlineshopping.entity.Invoice;
import doan.onlineshopping.entity.InvoiceDetail;
import doan.onlineshopping.entity.Product;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {

	@Query(value = "SELECT top 1 * FROM Invoice ORDER BY invoice_id DESC", nativeQuery = true)
	public Invoice getLatestInvoice();

	@Query(value = "SELECT * FROM Invoice WHERE buyer_id=?1", nativeQuery = true)
	public List<Invoice> getInvoiceByBuyerID(String id);

	@Query(value = "SELECT * FROM Invoice WHERE seller_id=?1", nativeQuery = true)
	public List<Invoice> getInvoiceBySellerID(String id);

	@Query(value = "Select * from Invoice where MONTH(date) = '6' and seller_id=?1 and status='Đã hoàn thành'", nativeQuery = true)
	public List<Invoice> getInvoiceByMonth(String id);

	@Query(value = "Select * from Invoice where MONTH(date) = '6' and buyer_id=?1", nativeQuery = true)
	public List<Invoice> getInvoiceByBuyer(String id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Invoice SET status ='Đã giao' WHERE invoice_id =?1", nativeQuery = true)
	public void updateInvoiceStatus(int invoiceID);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Invoice SET status ='Đã hoàn thành' WHERE invoice_id =?1", nativeQuery = true)
	public void updateInvoiceStatusSeller(int invoiceID);
	
	@Query(value = "SELECT distinct buyer_id FROM Invoice WHERE seller_id=?1", nativeQuery = true)
	public List<String> getBuyerBySellerID(String id);
}
