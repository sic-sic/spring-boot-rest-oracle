package com.sicsic.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(generator = "customerSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="customerSeq", sequenceName="customer_sequence", initialValue = 1000, allocationSize = 50)
	private Long id;
	
	private String name;
	
	private String email;
	
	private int age;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
