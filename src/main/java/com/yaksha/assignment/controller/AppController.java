package com.yaksha.assignment.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {

	private final RestTemplate restTemplate;

	public AppController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	// PUT request to update resource
	@PutMapping("/updateResource")
	public String sendPutRequest(@RequestParam String apiUrl, @RequestBody String requestData) {
		// Sending the PUT request to the external API
		HttpEntity<String> entity = new HttpEntity<>(requestData);
		String response = restTemplate.exchange(apiUrl, HttpMethod.PUT, entity, String.class).getBody();

		// Return the response from the external API, along with the sent data
		return "Data to update: " + requestData + "\nResponse from API: " + response;
	}
}
