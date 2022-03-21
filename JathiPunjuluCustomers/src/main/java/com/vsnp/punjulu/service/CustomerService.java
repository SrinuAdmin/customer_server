package com.vsnp.punjulu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsnp.punjulu.exception.CustomerNotFoundException;
import com.vsnp.punjulu.model.Customer;
import com.vsnp.punjulu.model.Punjulu;
import com.vsnp.punjulu.repo.CustomerRepo;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepo CustomerRepo;

	@Autowired
	private PunjuluService service;

	@Override
	@Transactional
	public String editCustomer(Long custId) {
		Customer customer = CustomerRepo.findById(custId).orElseThrow(() -> new CustomerNotFoundException(""));

		return "" + CustomerRepo.save(customer).getCustomerId();
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list = CustomerRepo.findAll();
		if (list == null || list.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		return list;
	}

	@Override
	public List<Punjulu> getAllPunjulu() {
		if( service.showPujulu()==null) {
			throw new CustomerNotFoundException("no punjulu avialble");
		}
		return  (List<Punjulu>) service.showPujulu().getBody();
	}

	@Override
	public String saveCustomer(Customer customer) {
		try {
			Customer cust=CustomerRepo.save(customer);
			return "" + cust.getCustomerId();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerNotFoundException("Customer not saved");
		}
	}

	@Override
	public List<Customer> getSearchedCustomer(String name) {
		List<Customer> list = CustomerRepo.findAllByCustomerName(name);
		if (list == null || list.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		return list;
	}

	@Override
	public Customer getOneCustId(Long id) {
		Customer customer = CustomerRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		return customer;
	}

	@Override
	public Customer getOneCustEMail(String email) {
		Customer customer = CustomerRepo.findByEmail(email);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found");
		}
		return customer;
	}

}
