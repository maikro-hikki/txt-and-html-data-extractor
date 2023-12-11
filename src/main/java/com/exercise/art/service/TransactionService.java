package com.exercise.art.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.art.model.Transaction;
import com.exercise.art.repository.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;

	public Transaction addTransaction(Transaction transaction) {

		return transactionRepo.save(transaction);
	}
	
	public List<Transaction> findByDate(String date){
		
		return transactionRepo.findByDate(date);
	}
	
	public List<Transaction> findByArtistNameAndDate(String name, String date){
		
		return transactionRepo.findByArtistNameAndDate(name, date);
	}
	
	public List<Transaction> findByArtistName(String name){
		
		return transactionRepo.findByArtworkArtistName(name);
	}
}
