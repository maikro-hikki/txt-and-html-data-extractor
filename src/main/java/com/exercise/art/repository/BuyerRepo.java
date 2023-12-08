package com.exercise.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.art.model.Buyer;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Long>{

}
