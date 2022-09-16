package com.iiht.training.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.iiht.training.auction.dto.CustomerDto;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private BidsService bidsService;

	@PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody CustomerDto customerDto){
        try {
			return new ResponseEntity<CustomerDto>(customerService.registerCustomer(customerDto), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody CustomerDto customerDto){
        try{
            return new ResponseEntity<CustomerDto>(customerService.updateCustomer(customerDto), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get/all")
    public ResponseEntity<?> getAllCustomers(){
        return new ResponseEntity<List<CustomerDto>>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id){
        try {
			return new ResponseEntity<CustomerDto>(customerService.getCustomerById(id), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        try {
			return new ResponseEntity<Boolean>(customerService.deleteCustomer(id), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }
}
