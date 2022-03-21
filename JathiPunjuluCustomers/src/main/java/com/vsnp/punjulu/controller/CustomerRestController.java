package com.vsnp.punjulu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsnp.punjulu.exception.CustomerNotFoundException;
import com.vsnp.punjulu.model.Customer;
import com.vsnp.punjulu.model.Punjulu;
import com.vsnp.punjulu.service.ICustomerService;
import com.vsnp.punjulu.service.PunjuluService;

@RestController
@RefreshScope
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private ICustomerService service;
	
	@Autowired
	PunjuluService ps;

	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
		String custId = service.saveCustomer(customer);
		return ResponseEntity.ok(custId);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getCustomerDetails() {
		return ResponseEntity.ok(service.getAllCustomer());
	}
	
	@GetMapping("/allPunjulu")
	public ResponseEntity<?> getPunjuluDetails() {
		return ResponseEntity.ok(ps.showPujulu());
	}

	@GetMapping("/getCust/{customerId}")
	public ResponseEntity<Customer> getOneCustomerById(@PathVariable Long customerId) {
		ResponseEntity<Customer> resp = null;
		try {

			Customer customer = service.getOneCustId(customerId);
			resp = ResponseEntity.ok(customer);
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		} catch (Exception es) {
			es.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/get/{email}")
	public ResponseEntity<Customer> getOneCustomerByMail(@PathVariable String email) {
		ResponseEntity<Customer> resp = null;
		try {
			Customer customer = service.getOneCustEMail(email);
			resp = ResponseEntity.ok(customer);
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
		} catch (Exception es) {
			es.printStackTrace();
		}
		return resp;
	}

}
