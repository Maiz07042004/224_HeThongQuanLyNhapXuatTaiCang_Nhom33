
package doan.onlineshopping.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
//lan sau thay loi ni thi bo s
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import doan.onlineshopping.entity.Account;
import doan.onlineshopping.entity.Category;
import doan.onlineshopping.entity.GioHangDetail;
import doan.onlineshopping.entity.GioHangID;
import doan.onlineshopping.entity.Invoice;
import doan.onlineshopping.entity.InvoiceDetail;
import doan.onlineshopping.entity.InvoiceDetailId;
import doan.onlineshopping.entity.Product;
import doan.onlineshopping.model.AccountDTO;
import doan.onlineshopping.service.impl.AccountServiceImpl;
import doan.onlineshopping.service.impl.CategoryServiceImpl;
import doan.onlineshopping.service.impl.GioHangDetailServiceImpl;
import doan.onlineshopping.service.impl.InvoiceDetailServiceImpl;
import doan.onlineshopping.service.impl.InvoiceServiceImpl;
import doan.onlineshopping.service.impl.ProductServiceImpl;

@Controller
@RequestMapping(value = { "/", "Ticket_Selling" })
public class OnlineShoppingController {

	@Autowired
	AccountServiceImpl accountService;


	@Autowired
	InvoiceServiceImpl invoiceService;

	@Autowired
	InvoiceDetailServiceImpl invoiceDetailService;

	@Autowired
	CategoryServiceImpl categoryService;

	@Autowired
	ProductServiceImpl productService;

	@Autowired
	GioHangDetailServiceImpl giohangdetailService;

	/* Gọi home page */
	@RequestMapping(value = { "/", "homePage" })
	public String homePage(Model model) {
		List<Category> listCategory = categoryService.getListCategory();
		model.addAttribute("listCategory", listCategory);
		List<Product> listProduct = productService.getListProduct();
		model.addAttribute("listProduct", listProduct);
		return "homePage";

	}

	@RequestMapping(value = { "/sortCategory/{categoryID}" })
	public String sortCategory(Model model, @PathVariable int categoryID) {
		List<Category> listCategory = categoryService.getListCategory();
		model.addAttribute("listCategory", listCategory);
		List<Product> listProduct = productService.getProductByCategoryID(categoryID);
		model.addAttribute("listProduct", listProduct);
		return "homePage";

	}

	/******/

	@RequestMapping(value = { "/homePageAdmin" })
	public String homePageAdmin(Model model) {

		return "homePageAdmin";

	}

	@GetMapping(value = "/forgotpassword")
	public String forgotpassword(Model model) {

		return "forgotpassword";

	}

	@RequestMapping(value = { "/homePageSeller" })
	public String homePageSeller(Model model) {

		return "home_page_seller";

	}

	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	@RequestMapping(value = { "/duyetSeller" })
	public String duyetSeller(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Account> listSeller = accountService.getListSeller();
		model.addAttribute("listSeller", listSeller);
		return "danhSachSeller";

	}

	@RequestMapping(value = { "/updateSeller/{userName}" })
	public String updateSeller(Model model, @PathVariable String userName, HttpSession httpSession) {
		accountService.updateListSeller(userName);
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Account> listSeller = accountService.getListSeller();
		model.addAttribute("listSeller", listSeller);
		model.addAttribute("messageapprove", true);
		return "danhSachSeller";
	}

	@RequestMapping(value = { "errorPage" })
	public String errorPage(Model model) {

		String error = "This function does not exist!";

		model.addAttribute("errorData", error);

		return "error404";
	}

	@RequestMapping(value = { "/listDanhMuc" })
	public String listDanhMuc(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Category> listCategory = categoryService.getListCategory();
		model.addAttribute("listCategory", listCategory);

		return "danhSachDanhMuc";

	}

	@RequestMapping(value = { "/updateDanhMuc/{categoryID}" })
	public String updateDanhMuc(Model model, @PathVariable int categoryID) {
		Category category = categoryService.getCategoryById(categoryID);
		model.addAttribute("category", category);
		return "updateDanhMuc";

	}

	@RequestMapping(value = { "/thucHienUpdateSanPham" })
	public String thucHienUpdateSanPham(@ModelAttribute("product") Product product, Model model) {
		productService.addOrEditProduct(product);
		model.addAttribute("update", true);
		return "redirect:/listSanPham";

	}

	@RequestMapping(value = { "/thucHienUpdateDanhMuc" })
	public String thucHienUpdateDanhMuc(@ModelAttribute("category") Category category, Model model) {
		categoryService.addOrEditCategory(category);
		model.addAttribute("update", true);
		return "redirect:/listDanhMuc";

	}

	@RequestMapping(value = { "/thucHienUpdateProfile" })
	public String thucHienUpdateDanhMuc(@ModelAttribute("formAccount")AccountDTO accountDTO, Account account, Model model) {
		
		account.setOne_time_password(45566);
		accountService.addOrEditAccount(account);
		model.addAttribute("update", true);
		return "redirect:/updateProfile";

	}

	@RequestMapping(value = { "/thucHienThemMoiDanhMuc" })
	public String thucHienThemMoiDanhMuc(@ModelAttribute("category") Category category, Model model) {
		categoryService.addOrEditCategory(category);
		model.addAttribute("insert", true);
		return "redirect:/listDanhMuc";
	}

	@RequestMapping(value = { "/updateSanPham/{productID}" })
	public String updateSanPham(Model model, @PathVariable int productID) {
		Product product = productService.getProductById(productID);
		Map<Integer, String> ListCategoryID = new HashMap<Integer, String>();
		List<Category> listCategory = categoryService.getListCategory();
		for (Category category : listCategory) {
			ListCategoryID.put(category.getCategoryID(), category.getCategoryName());
		}
		model.addAttribute("listCategoryID", ListCategoryID);
		model.addAttribute("product", product);
		return "updateSanPham";

	}

	@RequestMapping(value = { "/themMoiSanPham" })
	public String themMoiSanPham(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		Map<Integer, String> ListCategoryID = new HashMap<Integer, String>();
		List<Category> listCategory = categoryService.getListCategory();
		for (Category category : listCategory) {
			ListCategoryID.put(category.getCategoryID(), category.getCategoryName());
		}
		model.addAttribute("product", new Product());
		model.addAttribute("listCategoryID", ListCategoryID);
		return "themMoiSanPham";
	}

	@RequestMapping(value = { "/dsSeller" })
	public String showSeller(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Account> listSeller = accountService.getListSellerByMonth();
		model.addAttribute("listSeller", listSeller);
		return "dsSeller";
	}
	
	@RequestMapping(value = { "/dsBuyer" })
	public String showBuyer(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<String> listInvoice = invoiceService.getBuyerBySellerID(account.getAccountID());
		model.addAttribute("listInvoice", listInvoice);
		List<Account> listAccount = accountService.getListAccount();
		model.addAttribute("listAccount", listAccount);
		return "dsBuyer";
	}
	@RequestMapping(value = { "/thucHienThemMoiSanPham" })
	public String thucHienThemMoiSanPham(@ModelAttribute("product") Product product, Model model,
			HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		product.setSellerID(account.getAccountID());
		productService.addOrEditProduct(product);
		model.addAttribute("insert", true);
		return "redirect:/themMoiSanPham";
	}

	@RequestMapping(value = { "/deleteDanhMuc/{categoryID}" })
	public String thucHienDeleteDanhMuc(Model model, @PathVariable int categoryID) {
		categoryService.deleteCategory(categoryID);
		model.addAttribute("delete", true);
		return "redirect:/listDanhMuc";

	}

	@RequestMapping(value = { "/showCategory" })
	public String showCategory(Model model) {
		List<Product> listProduct = productService.getListProduct();
		model.addAttribute("listProduct", listProduct);
		List<Category> listCategory = categoryService.getListCategory();
		model.addAttribute("listCategory", listCategory);
		return "showCategory";

	}

	@RequestMapping(value = { "/themMoiDanhMuc" })
	public String themMoiDanhMuc(Model model) {
		model.addAttribute("category", new Category());
		return "themMoiDanhMuc";
	}

	@RequestMapping(value = { "/updateProfile" })
	public String updateProfile(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		model.addAttribute("account", account);
		return "updateProfile";
	}

	@RequestMapping(value = { "/themAdmin" })
	public String themAdmin(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		return "themAdmin";
	}

	String productTmp = null;

	@RequestMapping(value = { "productDetail/{productName}" })
	public String productDetail(Model model, @PathVariable String productName) {
		productTmp = productName;
		return "redirect:/chiTietProduct";
	}

	@RequestMapping(value = { "/chiTietProduct" })
	public String chiTietProduct(Model model, HttpSession httpSession) {
		Product product = productService.getProductByProductName(productTmp);
		model.addAttribute("product", product);
		return "productDetail";

	}

	@RequestMapping(value = { "/listSanPham" })
	public String listSanPham(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Product> listProduct = productService.getListProduct();
		model.addAttribute("listProduct", listProduct);
		return "danhSachSanPham";
	}

	@RequestMapping(value = { "/deleteCart/{productID}" })
	public String thucHienDeleteCart(Model model, @PathVariable int productID, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		GioHangID giohangid = new GioHangID();
		giohangid.setAccountID(account.getAccountID());
		giohangid.setProductID(productID);
		giohangdetailService.deleteGioHangDetail(giohangid);
		model.addAttribute("delete", true);
		return "redirect:/toCart";
	}

	@RequestMapping(value = { "/toCart" })
	public String toCart(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Product> listProduct = productService.findProductByGioHangDetail(account.getAccountID());
		model.addAttribute("listProduct", listProduct);
		List<GioHangDetail> listGioHangDetail = giohangdetailService.findProductByAccountID(account.getAccountID());
		model.addAttribute("listGioHangDetail", listGioHangDetail);
		return "toCart";
	}

	@RequestMapping(value = { "/showInvoice" })
	public String showInvoice(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Invoice> listInvoice = invoiceService.getInvoiceByBuyerID(account.getAccountID());
		List<InvoiceDetail> listInvoiceDetail = invoiceDetailService.getListInvoiceDetail();
		List<Product> listProduct = productService.getListProduct();
		model.addAttribute("listInvoiceDetail", listInvoiceDetail);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listInvoice", listInvoice);
		return "danhSachHoaDon";
	}
	@RequestMapping(value = { "/thongKeDoanhThu" })
	public String showDoanhThu(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Invoice> listInvoice = invoiceService.getInvoiceByMonth(account.getAccountID());
		List<InvoiceDetail> listInvoiceDetail = invoiceDetailService.getListInvoiceDetail();
		List<Product> listProduct = productService.getListProduct();
		model.addAttribute("listInvoiceDetail", listInvoiceDetail);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listInvoice", listInvoice);
		return "thongKeDoanhThu";
	}
	
	@RequestMapping(value = { "/thongKeTongTien" })
	public String showTongTien(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Invoice> listInvoice = invoiceService.getInvoiceByBuyer(account.getAccountID());
		List<InvoiceDetail> listInvoiceDetail = invoiceDetailService.getListInvoiceDetail();
		List<Product> listProduct = productService.getListProduct();
		model.addAttribute("listInvoiceDetail", listInvoiceDetail);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listInvoice", listInvoice);
		return "thongKeTongTien";
	}
	@RequestMapping(value = { "/showSellerDetail/{username}" })
	public String showSellerDetail(Model model, HttpSession httpSession, @PathVariable String username) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		
		List<Invoice> listInvoice = invoiceService.getInvoiceByMonth(username);
		List<InvoiceDetail> listInvoiceDetail = invoiceDetailService.getListInvoiceDetail();
		List<Product> listProduct = productService.getListProduct();
		model.addAttribute("listInvoiceDetail", listInvoiceDetail);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listInvoice", listInvoice);
		return "SellerDetail";
	}
	
	@RequestMapping(value = { "/showBuyerDetail/{username}" })
	public String showBuyerDetail(Model model, HttpSession httpSession, @PathVariable String username) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Invoice> listInvoice = invoiceService.getInvoiceByBuyer(username);
		List<InvoiceDetail> listInvoiceDetail = invoiceDetailService.getListInvoiceDetail();
		List<Product> listProduct = productService.getListProduct();
		model.addAttribute("listInvoiceDetail", listInvoiceDetail);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("listInvoice", listInvoice);
		return "BuyerDetail";
	}
	@RequestMapping(value = { "/quanLyDonHang" })
	public String quanLyDonHang(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Invoice> listInvoice = invoiceService.getInvoiceBySellerID(account.getAccountID());
		model.addAttribute("listInvoice", listInvoice);
		return "danhSachDonHang";
	}
	
	@RequestMapping(value = { "/confirmBuying" })
	public String confirmBuying(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Product> listProduct = productService.findProductByGioHangDetail(account.getAccountID());
		model.addAttribute("listProduct", listProduct);
		List<GioHangDetail> listGioHangDetail = giohangdetailService.findProductByAccountID(account.getAccountID());
		model.addAttribute("listGioHangDetail", listGioHangDetail);
		return "confirmBuying";
	}

	@RequestMapping(value = { "/Ticket_Selling/Buying/{productID}/{soLuong}" })
	public String Buying(Model model, @PathVariable int productID, @PathVariable int soLuong, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		Product product = new Product();
		product = productService.getProductById(productID);
		model.addAttribute("product", product);
		GioHangDetail giohangDetail = new GioHangDetail();
		giohangDetail.setQuantity(soLuong);
		model.addAttribute("giohangDetail", giohangDetail);
		return "directBuying";
	}

	@RequestMapping(value = { "/Ticket_Selling/addToCart/{soLuong}/{productID}" })
	public String addToCart(Model model, @PathVariable int soLuong, @PathVariable int productID,
			HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		LocalDate date = LocalDate.now();
		GioHangDetail gioHangDetail = new GioHangDetail();
		GioHangID gioHangId = new GioHangID();
		gioHangId.setAccountID(account.getAccountID());
		gioHangId.setProductID(productID);
		gioHangDetail.setGioHangID(gioHangId);
		gioHangDetail.setQuantity(soLuong);
		gioHangDetail.setDate(date);
		giohangdetailService.addOrEditGioHangDetail(gioHangDetail);
		return "redirect:/chiTietProduct";
	}

	@RequestMapping(value = { "/deleteSanPham/{productID}" })
	public String thucHienDeleteSanPHam(Model model, @PathVariable int productID) {
		productService.deleteProduct(productID);
		model.addAttribute("delete", true);
		return "redirect:/listSanPham";
	}

	@RequestMapping(value = { "/Ticket_Selling/updateQuantity/{quantity}/{productID}" })
	public String updateQuantity(Model model, @PathVariable int quantity, @PathVariable int productID,
			HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		giohangdetailService.updateQuantity(productID, account.getAccountID(), quantity);
		return "redirect:/toCart";

	}

	@RequestMapping(value = { "/updateInvoice/{invoiceID}" })
	public String thucHienUpdateInvoice(Model model, @PathVariable int invoiceID, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		invoiceService.updateInvoiceStatus(invoiceID);
		return "redirect:/showInvoice";
	}
	
	@RequestMapping(value = { "/updateInvoiceSeller/{invoiceID}" })
	public String thucHienUpdateInvoiceSeller(Model model, @PathVariable int invoiceID, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		invoiceService.updateInvoiceStatusSeller(invoiceID);
		return "redirect:/quanLyDonHang";
	}

	@RequestMapping(value = { "/listHangTon" })
	public String showHangTon(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Product> listProduct = productService.getProductBySellerID(account.getAccountID());
		model.addAttribute("listProduct", listProduct);
		return "danhSachHangTon";
	}
	@RequestMapping(value = { "/confirmed" })
	public String confirmed(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if (account == null) {
			return "redirect:/login";
		}
		List<Product> listProduct = productService.findProductByGioHangDetail(account.getAccountID());
		model.addAttribute("listProduct", listProduct);
		List<GioHangDetail> listGioHangDetail = giohangdetailService.findProductByAccountID(account.getAccountID());
		model.addAttribute("listGioHangDetail", listGioHangDetail);
		Invoice invoice = new Invoice();
		invoice.setBuyerId(account.getAccountID());
		invoice.setDate(LocalDate.now());
		invoice.setDeleteFlag(0);
		invoice.setStatus("Đã xác nhận");
		invoiceService.addOrEditInvoice(invoice);
		InvoiceDetail invoiceDetail = new InvoiceDetail();
		InvoiceDetailId id = new InvoiceDetailId();
		Invoice invoiceTmp = new Invoice();
		invoiceTmp = invoiceService.getLatestInvoice();
		id.setInvoiceID(invoiceTmp.getInvoiceId());
		for (GioHangDetail gioHangDetail : listGioHangDetail) {
			for (Product product : listProduct) {
				if (gioHangDetail.getGioHangID().getProductID() == product.getProductID()) {
					int slgmua = gioHangDetail.getQuantity();
					int kho = product.getQuantity();
					int sl = kho - slgmua;
					invoice.setSellerId(product.getSellerID());
					productService.updateQuantity(sl, product.getProductID());
					id.setProductID(product.getProductID());
					invoiceDetail.setId(id);
					invoiceDetail.setDeleteFlag(0);
					invoiceDetail.setSoLuongMua(gioHangDetail.getQuantity());
					invoiceDetailService.addOrEditInvoiceDetail(invoiceDetail);
				}
			}
			
			giohangdetailService.deleteGioHangDetail(gioHangDetail.getGioHangID());

		}
		invoiceService.addOrEditInvoice(invoice);
		return "confirmed";

	}
}
