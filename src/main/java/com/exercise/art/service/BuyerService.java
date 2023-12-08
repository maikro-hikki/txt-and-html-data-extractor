package com.exercise.art.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.art.model.Buyer;
import com.exercise.art.repository.BuyerRepo;

@Service
public class BuyerService {
	
	@Autowired
	private BuyerRepo buyerRepo;
	
	public Buyer addBuyer(Buyer buyer){
		
		return buyerRepo.save(buyer);
	}

}
