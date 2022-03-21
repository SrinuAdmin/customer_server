package com.vsnp.punjulu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vsnp.punjulu.pojo.Address;

@Table(name = "customer")
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long customerId;
	@Column(name = "customer_name")
	private String customerName;

	private String email;

	@JoinColumn(name = "customer_address")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
