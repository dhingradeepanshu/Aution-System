package com.iiht.training.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.service.BidsService;
import com.iiht.training.auction.service.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private BidsService bidsService;

    @PostMapping("/register")
    public ResponseEntity<?> registerSeller(@Valid @RequestBody SellerDto sellerDto){
        try {
			return new ResponseEntity<SellerDto>(sellerService.registerSeller(sellerDto), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSeller(@Valid @RequestBody SellerDto sellerDto){
        try{
            return new ResponseEntity<SellerDto>(sellerService.updateSeller(sellerDto), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get/all")
    public ResponseEntity<?> getAllSellers(){
        return new ResponseEntity<List<SellerDto>>(sellerService.getAllSellers(), HttpStatus.OK);
    }

    @GetMapping("get/{sellerId}")
    public ResponseEntity<?> getSellerById(@PathVariable("sellerId") Long sellerId){
        try {
			return new ResponseEntity<SellerDto>(sellerService.getSellerById(sellerId), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping("/delete/{sellerId}")
    public ResponseEntity<?> deleteSeller(@PathVariable("sellerId") Long sellerId){
        try {
			return new ResponseEntity<Boolean>(sellerService.deleteSeller(sellerId), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }
}
