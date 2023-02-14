package com.example.SalesforceIntegrationApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SalesforceIntegrationApp.classes.SalesforceAuthenticator;

@SpringBootApplication
public class SalesforceIntegrationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesforceIntegrationAppApplication.class, args);
		SalesforceAuthenticator salesforceAuthenticator = SalesforceAuthenticator.getSalesforceToken();
	}

}
