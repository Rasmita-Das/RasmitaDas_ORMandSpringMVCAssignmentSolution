package com.gl.service;

import java.util.List;

import com.gl.entity.Customer;

public interface CusSrvc {
	
	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCus);
	
	public void delete(int theId);

}
