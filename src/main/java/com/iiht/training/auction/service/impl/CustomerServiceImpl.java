package com.iiht.training.auction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.repository.CustomerRepository;
import com.iiht.training.auction.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDto registerCustomer(CustomerDto customerDto) {
		return null;
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		return null;
	}

	@Override
	public Boolean deleteCustomer(Long id) {
		return false;
	}

	@Override
	public CustomerDto getCustomerById(Long id) {
		return null;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {

		return null;
	}

}
