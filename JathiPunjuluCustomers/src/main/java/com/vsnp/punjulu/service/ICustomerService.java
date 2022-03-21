package com.vsnp.punjulu.service;

import java.util.List;

import com.vsnp.punjulu.model.Customer;
import com.vsnp.punjulu.model.Punjulu;

public interface ICustomerService {

	abstract String saveCustomer(Customer customer);

	abstract String editCustomer(Long punjuId);

	abstract List<Customer> getAllCustomer();

	abstract List<Customer> getSearchedCustomer(String type);

	abstract Customer getOneCustId(Long id);

	abstract Customer getOneCustEMail(String email);

	abstract List<Punjulu> getAllPunjulu();

}
