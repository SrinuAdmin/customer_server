package com.vsnp.punjulu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsnp.punjulu.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	Customer findByEmail(String email);
	List<Customer> findAllByCustomerName(String name);
	
}
