/*	
 
*
* @author HCD-Fresher084
* @date Apr 16, 2021
 
*/

package doan.cangtiensa.controller;

import java.time.LocalDate;

import java.util.Random;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import doan.cangtiensa.entity.Account;
import doan.cangtiensa.entity.Roles;
import doan.cangtiensa.model.AccountDTO;
import doan.cangtiensa.service.impl.AccountServiceImpl;
import doan.cangtiensa.service.impl.RolesServiceImpl;

@Controller
public class RegisterController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	int upperbound = 100000;
	int otpcheck = 0;
	int otpcheck2 = 0;
	Roles roleBuyer = new Roles(2);
	Roles roleSeller = new Roles(3);
	Roles roleAdmin = new Roles(1);
	int regisRole = 0;

	@Autowired
	AccountServiceImpl accountServiceImpl;

	@Autowired
	RolesServiceImpl rolesServiceImpl;

	@GetMapping(value = "/register")
	public String pageRegister(Model model) {
		return "/register";
	}

	@PostMapping("/register")
	public String postRegister(@ModelAttribute("formRegister") AccountDTO accountDTO, Account account, Model model) {
		int otp = accountDTO.getOne_time_password();
		if (otp != otpcheck) {
			model.addAttribute("messageOTP", true);
			return "redirect:/register";
		}
		account.setAccountID(accountDTO.getUserName());
		account.setFullName(accountDTO.getFullName());
		account.setAddress(accountDTO.getAddress());
		account.setDateOfBirth(LocalDate.parse(accountDTO.getDateOfBirth()));
		account.setGender(accountDTO.getGender());
		account.setPassword(accountDTO.getPassword());
		account.setUserName(accountDTO.getUserName());
		account.setPhoneNumber(accountDTO.getPhoneNumber());
		account.setStatus(1);
		account.setIdentityCard(accountDTO.getIdentityCard());
		account.setEmail(accountDTO.getEmail());
		account.setRegisterDate(LocalDate.now());
		account.setDeleteFlag(0);
		account.setOne_time_password(accountDTO.getOne_time_password());
		regisRole = accountDTO.getRoleID();
		account.setSeller_approve_flag(0);
		if (regisRole == 2) {
			account.setRoles(roleBuyer);
		}
		if (regisRole == 3) {
			account.setRoles(roleSeller);
			account.setSeller_approve_flag(1);
		}
		/*
		 * if (accountDTO.getRoleID() == 2) { account.setRoles(roleBuyer); } else if
		 * (accountDTO.getRoleID() == 3) { account.setRoles(roleSeller); }
		 */
		accountServiceImpl.addOrEditAccount(account);
		model.addAttribute("messageRegister", true);
		return "redirect:/login";

	}

	@PostMapping("/themAdmin")
	public String postAddAdmin(@ModelAttribute("formAddAdmin") AccountDTO accountDTO, Account account, Model model) {
		account.setAccountID(accountDTO.getUserName());
		account.setFullName(accountDTO.getFullName());
		account.setAddress(accountDTO.getAddress());
		account.setDateOfBirth(LocalDate.parse(accountDTO.getDateOfBirth()));
		account.setGender(accountDTO.getGender());
		account.setPassword(accountDTO.getPassword());
		account.setUserName(accountDTO.getUserName());
		account.setPhoneNumber(accountDTO.getPhoneNumber());
		account.setStatus(1);
		account.setIdentityCard(accountDTO.getIdentityCard());
		account.setEmail(accountDTO.getEmail());
		account.setRegisterDate(LocalDate.now());
		account.setDeleteFlag(0);
		account.setOne_time_password(00000);
		regisRole = accountDTO.getRoleID();
		account.setSeller_approve_flag(0);
		account.setRoles(roleAdmin);
		accountServiceImpl.addOrEditAccount(account);
		model.addAttribute("messageAdmin", true);
		return "redirect:/homePage";

	}

	@RequestMapping(value = { "/Ticket_Selling/getOtp/{email}" })
	public String sendOTP(Model model, @PathVariable String email) {
		int random = rand.nextInt(upperbound);
		accountServiceImpl.getOtp(email, random);
		otpcheck = random;
		model.addAttribute("messageOTP", true);
		return "redirect:/register";
	}

	/*
	 * @RequestMapping(value = { "/Ticket_Selling/test" }) public String test(Model
	 * model, Account account) {
	 * 
	 * account = accountServiceImpl.getAccountByEmail(email); if (account == null) {
	 * model.addAttribute("messageOTP", true); System.out.println("Hello Null");
	 * return "login"; } else { int random = rand.nextInt(upperbound);
	 * accountServiceImpl.getOtp(email, random); otpcheck2 = random;
	 * accountServiceImpl.updateOTP(email, random); model.addAttribute("messageOTP",
	 * true); return "redirect:/forgotpassword"; }
	 * 
	 * System.out.println("Hello Hello Null"); return "login"; }
	 */
	@RequestMapping(value = { "/getOtppass/{email}" })
	public String sendOTPpass(Model model, @PathVariable String email, Account account) {
		account = accountServiceImpl.getAccountByEmail(email);
		if (account == null) {
			model.addAttribute("messageWrongEmail", true);
			return "redirect:/forgotpassword";
		} else {
			int random = rand.nextInt(upperbound);
			accountServiceImpl.getOtp(email, random);
			otpcheck2 = random;
			accountServiceImpl.updateOTP(email, random);
			model.addAttribute("messageOTP", true);
			return "redirect:/forgotpassword";
		}
	}

	@PostMapping(value = "/forgotpassword")
	public String postPassword(@ModelAttribute("formPassword") AccountDTO accountDTO, Account account, Model model) {
		int otp = accountDTO.getOne_time_password();
		if (otp != otpcheck2) {
			model.addAttribute("messagePassword", true);
			return "redirect:/forgotpassword";
		} else {
			String email = accountDTO.getEmail();
			String password = accountDTO.getPassword();
			accountServiceImpl.updatePassword(email, password);
			model.addAttribute("updatepassword", true);
			return "redirect:/login";
		}

	}

	@RequestMapping(value = { "/Ticket_Selling/deleteNhanVien/{accountID}" })
	public String thucHienDeleteNhanVien(Model model, @PathVariable String accountID) {
		accountServiceImpl.deleteMovie(accountID);
		model.addAttribute("delete", true);
		return "redirect:/listNhanVien";

	}

}
