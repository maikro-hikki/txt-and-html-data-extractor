package com.exercise.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.art.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{

}
