/*	
*	(C) Copyright 2021 Fresher56. All Rights Reserved
*
* @author HCD-Fresher084
* @date Apr 16, 2021
* @ version 1.0
*/

package doan.movietheater.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import doan.movietheater.entity.Account;
import doan.movietheater.entity.Member;
import doan.movietheater.entity.Roles;
import doan.movietheater.model.AccountDTO;
import doan.movietheater.service.impl.AccountServiceImpl;
import doan.movietheater.service.impl.MemberServiceImpl;
import doan.movietheater.service.impl.RolesServiceImpl;

@Controller
public class RegisterController {
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@Autowired
	RolesServiceImpl rolesServiceImpl;
	
	@Autowired
	MemberServiceImpl memberServiceImpl;
	
	@GetMapping("/register")
	public String pageRegister(Model model ) {
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegister(@ModelAttribute("formRegister") AccountDTO accountDTO, Account account, Model model) {
		Roles roles = rolesServiceImpl.getMovieById(accountDTO.getRoleID());
		account.setAccountID(accountDTO.getUserName());
		account.setFullName(accountDTO.getFullName());
		account.setAddress(accountDTO.getAddress());
		account.setDateOfBirth(LocalDate.parse(accountDTO.getDateOfBirth()));
		account.setGender(accountDTO.getGender());
		account.setPassword(accountDTO.getPassword());
		account.setUserName(accountDTO.getUserName());
		account.setPhoneNumber(accountDTO.getPhoneNumber());
		account.setRoles(roles);
		account.setStatus(1);
		account.setIdentityCard(accountDTO.getIdentityCard());
		account.setEmail(accountDTO.getEmail());
		account.setRegisterDate(LocalDate.now());
		account.setDeleteFlag(0);
		accountServiceImpl.addOrEditMovie(account);
		Member member = new Member();
		member.setMemberID(accountDTO.getUserName());
		member.setDeleteFlag(0);
		member.setScore(0);
		member.setAccount(account);
		memberServiceImpl.addOrEditMovie(member);
		model.addAttribute("messageRegister", true);
		return "redirect:/login";
	}
	
	@RequestMapping(value = { "/Ticket_Selling/deleteKhachHang/{accountID}" })
	public String thucHienDeleteKhachHang(Model model, @PathVariable String accountID) {
		accountServiceImpl.deleteMovie(accountID);
		model.addAttribute("delete", true);
		return "redirect:/listKhachHang";

	}
	
	@RequestMapping(value = { "/Ticket_Selling/deleteNhanVien/{accountID}" })
	public String thucHienDeleteNhanVien(Model model, @PathVariable String accountID) {
		accountServiceImpl.deleteMovie(accountID);
		model.addAttribute("delete", true);
		return "redirect:/listNhanVien";

	}

}
