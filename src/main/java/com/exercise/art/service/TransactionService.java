package com.exercise.art.service;

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
}
