/*	
*	(C) Copyright 2024 Fresher56. All Rights Reserved
*
* @author ADMIN
* @date May 13, 2024
 
*/

package doan.onlineshopping.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import doan.onlineshopping.entity.Category;
import doan.onlineshopping.entity.GioHangDetail;
import doan.onlineshopping.entity.Invoice;
import doan.onlineshopping.entity.InvoiceDetail;
import doan.onlineshopping.entity.InvoiceDetailId;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, InvoiceDetailId>  {
	

}
