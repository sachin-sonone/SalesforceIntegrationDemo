package com.example.SalesforceIntegrationApp.classes;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/accounts")
	public Map getAccounts() {
		try {
			return accountService.getAccountList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Collections.emptyMap();
	}
}
