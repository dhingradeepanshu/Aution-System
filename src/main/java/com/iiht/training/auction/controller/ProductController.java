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

import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<?> registerProduct(@Valid @RequestBody ProductDto productDto){
        try {
			return new ResponseEntity<ProductDto>(productService.saveProduct(productDto), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto productDto){
        try{
            return new ResponseEntity<ProductDto>(productService.updateProduct(productDto), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get/all")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<List<ProductDto>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("get/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") Long productId){
        try {
			return new ResponseEntity<ProductDto>(productService.getProductById(productId), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Long productId){
        try {
			return new ResponseEntity<Boolean>(productService.deleteProduct(productId), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }
	
}
