package com.iiht.training.auction.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.ProductDto;
import com.iiht.training.auction.entity.ProductEntity;
import com.iiht.training.auction.exceptions.ProductNotFoundException;
import com.iiht.training.auction.repository.ProductRepository;
import com.iiht.training.auction.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDto saveProduct(ProductDto productDto) {
		return productRepository.save(productDto.toProductEntity()).toProductDto();
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) {
        if(productRepository.existsById(productDto.getProductId())){
            return productRepository.save(productDto.toProductEntity()).toProductDto();
        }else{
            throw new ProductNotFoundException("Product not found");
        }
	}

	@Override
	public Boolean deleteProduct(Long productId) {
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
            return true;
        }else{
            throw new ProductNotFoundException("Product not found");
        }
	}

	@Override
	public ProductDto getProductById(Long productId) {
        if(productRepository.existsById(productId)){
            ProductEntity entity = productRepository.findById(productId).get();
            return entity.toProductDto();
        }else{
            throw new ProductNotFoundException("Product not found");
        }
	}

	@Override
	public List<ProductDto> getAllProducts() {
        List<ProductEntity> allProducts = productRepository.findAll();
        List<ProductDto> allProductsDto = new ArrayList<ProductDto>();

        for(ProductEntity product : allProducts){
            allProductsDto.add(product.toProductDto());
        }

		return allProductsDto;
	}

	@Override
	public List<ProductDto> getProductsBySeller(Long sellerId) {
		return null;
	}

	@Override
	public List<ProductDto> getProductsByCategory(String category) {
		return null;
	}

}
