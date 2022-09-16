package com.iiht.training.auction.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.entity.CustomerEntity;
import com.iiht.training.auction.exceptions.CustomerNotFoundException;
import com.iiht.training.auction.repository.CustomerRepository;
import com.iiht.training.auction.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDto registerCustomer(CustomerDto customerDto) {
		return customerRepository.save(customerDto.toCustomerEntity()).toCustomerDto();
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		if(customerRepository.existsById(customerDto.getId())){
            return customerRepository.save(customerDto.toCustomerEntity()).toCustomerDto();
        }else{
            throw new CustomerNotFoundException("Customer not found");
        }
	}

	@Override
	public Boolean deleteCustomer(Long id) {
		if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return true;
        }else{
            throw new CustomerNotFoundException("Customer not found");
        }
	}

	@Override
	public CustomerDto getCustomerById(Long id) {
		if(customerRepository.existsById(id)){
            CustomerEntity entity = customerRepository.findById(id).get();
            return entity.toCustomerDto();
        }else{
            throw new CustomerNotFoundException("Customer not found");
        }
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
        List<CustomerEntity> allCustomers = customerRepository.findAll();
        List<CustomerDto> allCustomersDto = new ArrayList<CustomerDto>();

        for(CustomerEntity customer : allCustomers){
            allCustomersDto.add(customer.toCustomerDto());
        }

		return allCustomersDto;
	}

}
