package com.sicsic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicsic.demo.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
