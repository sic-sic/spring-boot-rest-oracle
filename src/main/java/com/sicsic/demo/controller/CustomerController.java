package com.sicsic.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sicsic.demo.domain.Customer;
import com.sicsic.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerRepository customerRepository;
	
	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping("")
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No customer found with Id : " + id));
	}
	
	@PostMapping("")
	public Customer saveCustomer(@RequestBody Customer customer) {
		if (customer.getId() != null) {
			throw new IllegalStateException("Can not create a customer with an Id");
		}
		return customerRepository.save(customer);
	}
	
	@PutMapping("")
	public Customer updateCustomer(@RequestBody Customer customer) {
		if (customer.getId() == null) {
			throw new IllegalStateException("Can not update a customer with no Id");
		}
		if (customerRepository.findById(customer.getId()).isPresent() == false) {
			throw new IllegalArgumentException("No customer found with Id : " + customer.getId());
		}
		return customerRepository.save(customer);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}
}
