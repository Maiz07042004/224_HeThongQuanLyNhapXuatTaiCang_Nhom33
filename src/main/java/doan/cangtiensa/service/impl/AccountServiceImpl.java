/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.cangtiensa.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.DataSource;

import doan.cangtiensa.entity.Account;

import doan.cangtiensa.repository.IAccountRepository;
import doan.cangtiensa.service.IAccountService;
@Service
public class AccountServiceImpl implements IAccountService {
	String emailAccount = "triet151102@gmail.com";
	
	@Autowired
	IAccountRepository accountRepository;

	@Override
	public List<Account> getListAccount() {
		return accountRepository.findAll();
	}
	
	@Override
	public Account getAccountById(String id) {
		return accountRepository.findOne(id);
	}

	/*
	 * @Override public void deleteAccount(String id) { return
	 * accountRepository.delete(id); }
	 */
	@Override
	public void addOrEditAccount(Account account) {
		accountRepository.save(account);
	}

	@Override
	public void deleteMovie(String id) {
		accountRepository.delete(id);
	}
	@Override
	public void deleteAccount(String userName) {
		accountRepository.delete(userName);
	}

	/**
	 * The function retrieves customer information by identity card number
	 */
	public Account getAccountByPhoneNumber(String phoneNumber) {
		return accountRepository.getAccountByPhoneNumber(phoneNumber);
	}
	
	public Account getAccountByUserName(String username) {
		return accountRepository.getAccountByUserName(username);
	}
	
	public List<Account> getListCustomer(){
		return accountRepository.getListCustomer();
	}
	
	public List<Account> getListNV(){
		return accountRepository.getListNV();
	}
	
	

	
	public Account getAccountByEmail(String email) {
		return accountRepository.getAccountByEmail(email);
	}
	

	
	public void updateOTP(String email, int OTP){
		accountRepository.updateOTP(email, OTP);
	}
	
	
	public void updatePassword(String email, String password){
		accountRepository.updatePassword(email, password);
	}
	
	@Override
	public void getOtp(String email, int otp) {
		String from = emailAccount;
		String password = "lxwsvxftjudvaiil";
		String to = email;
		int onetimepassword = otp;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}

		};
		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.setFrom(from);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
			msg.setSubject("Your OTP");
			msg.setSentDate(new Date());
			msg.setText("Your OTP is:" + onetimepassword, "UTF-8");
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
}
