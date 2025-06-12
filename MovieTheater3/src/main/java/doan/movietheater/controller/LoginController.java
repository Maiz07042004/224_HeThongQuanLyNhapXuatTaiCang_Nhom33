/*	
*	(C) Copyright 2021 Fresher56. All Rights Reserved
*
* @author tuand
* @date May 4, 2021
* @ version 1.0
*/

package doan.movietheater.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import doan.movietheater.entity.Account;
import doan.movietheater.service.impl.AccountServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@GetMapping(value="/login")
	public String loginPage() {
		return "/login";
	}
	
	@PostMapping(value="/login")
	public String postlogin(@ModelAttribute("formLogin") Account account, HttpSession httpSession, Model model) {
		Account account2 = accountServiceImpl.getAccountByUserName(account.getUserName());
		if(account2!=null && account2.getPassword().equals(account.getPassword())) {
			httpSession.setAttribute("account", account2);
			return "redirect:/homePage";
		} else {
			model.addAttribute("message",true);
			return "redirect:/login";
		}
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession httpSession) {
		httpSession.setAttribute("account", null);
		httpSession.invalidate();
		return "redirect:/homePage";
	}
}
