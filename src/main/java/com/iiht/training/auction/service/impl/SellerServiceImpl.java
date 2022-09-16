package com.iiht.training.auction.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.auction.dto.SellerDto;
import com.iiht.training.auction.entity.SellerEntity;
import com.iiht.training.auction.exceptions.SellerNotFoundException;
import com.iiht.training.auction.repository.SellerRepository;
import com.iiht.training.auction.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;

    

	@Override
	public SellerDto registerSeller(SellerDto sellerDto) {
        return sellerRepository.save(sellerDto.toSellerEntity()).toSellerDto();
	}

	@Override
	public SellerDto updateSeller(SellerDto sellerDto) {
		if(sellerRepository.existsById(sellerDto.getSellerId())){
            return sellerRepository.save(sellerDto.toSellerEntity()).toSellerDto();
        }else{
            throw new SellerNotFoundException("Seller not found");
        }
	}

	@Override
	public Boolean deleteSeller(Long sellerId){
        // TODO Auto-generated method stub
        if(sellerRepository.existsById(sellerId)){
            sellerRepository.deleteById(sellerId);
            return true;
        }else{
            throw new SellerNotFoundException("Seller not found");
        }
	}

	@Override
	public SellerDto getSellerById(Long sellerId) {
		if(sellerRepository.existsById(sellerId)){
            SellerEntity entity = sellerRepository.findById(sellerId).get();
            return entity.toSellerDto();
        }else{
            throw new SellerNotFoundException("Seller not found");
        }
	}

	@Override
	public List<SellerDto> getAllSellers() {
        List<SellerEntity> allSellers = sellerRepository.findAll();
        List<SellerDto> allSellersDto = new ArrayList<SellerDto>();

        for(SellerEntity seller : allSellers){
            allSellersDto.add(seller.toSellerDto());
        }

		return allSellersDto;
	}

}
