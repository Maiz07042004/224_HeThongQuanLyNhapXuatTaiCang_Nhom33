

package doan.cangtiensa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import doan.cangtiensa.entity.Account;
import doan.cangtiensa.entity.Roles;
import doan.cangtiensa.service.impl.AccountServiceImpl;

@Controller
public class LoginController {
	int roleId;
	int approveFlag;
	@Autowired
	AccountServiceImpl accountServiceImpl;

	@GetMapping(value = "/login")
	public String loginPage() {
		return "/login";
	}

	@SuppressWarnings("finally")
	@PostMapping(value = "/login")
	public String postlogin(@ModelAttribute("formLogin") Account account, HttpSession httpSession, Model model) {
		// try {
		Account account2 = accountServiceImpl.getAccountByUserName(account.getUserName());
		if (account2 != null && account2.getPassword().equals(account.getPassword())) {
			// check role
			roleId = account2.getRoles().getRoleID();
			approveFlag = account2.getSeller_approve_flag();
			if (roleId == 1) {
				httpSession.setAttribute("account", account2);
				return "redirect:/homePage";
			} else if (roleId == 2) {
				httpSession.setAttribute("account", account2);
				return "redirect:/homePage";
			} else {
				if (approveFlag == 1) {
					model.addAttribute("approvingmessage", true);
					return "redirect:/login";
				} else {
					httpSession.setAttribute("account", account2);
					return "redirect:/homePage";
				}
			}
		} else {
			model.addAttribute("message", true);
			return "redirect:/login";
		}

	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession httpSession) {
		httpSession.setAttribute("account", null);
		httpSession.invalidate();
		return "redirect:/homePage";
	}
}
