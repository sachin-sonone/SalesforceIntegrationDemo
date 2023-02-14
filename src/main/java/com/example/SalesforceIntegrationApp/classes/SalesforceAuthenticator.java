package com.example.SalesforceIntegrationApp.classes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SalesforceAuthenticator {
	
    private static SalesforceAuthenticator salesforceAuthenticator = null; 
    public static String accessToken;
    public static String instanceUrl;
    
    private SalesforceAuthenticator() {
    	try {
    		final String baseUrl = "<Your-instance-URL-goes-here>";
			URI uri = new URI(baseUrl);
			
	    	HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
			params.add("username", "<Your-username>");
			params.add("password", "<Your-password>");
			params.add("client_secret", "<Your-consumer-secret>");
			params.add("client_id", "<Your-consumer-id>");
			params.add("grant_type","password");
			
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Map> response = restTemplate.postForEntity(uri, request, Map.class);
			
			Map<String,String> responseBody = response.getBody();
	
			accessToken = responseBody.get("access_token");
			instanceUrl = responseBody.get("instance_url");
    	}catch(Exception e) {
        	System.out.println(e.getMessage()); 		
    	}
    }
	
    public static SalesforceAuthenticator getSalesforceToken() 
    { 
        try {
        	if (salesforceAuthenticator == null) 
	        { 
        		salesforceAuthenticator = new SalesforceAuthenticator();
	        	return salesforceAuthenticator;
	        }else {
	        	return salesforceAuthenticator;
	        }
        }catch(Exception e) {
        	e.printStackTrace();
        	System.out.println(e.getMessage());
        }
        return null;
    }
}





