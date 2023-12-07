package com.exercise.art.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private long transactionId;
	
	private double price;
	
	private String date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_productId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Buyer buyer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_productId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Artwork artwork;
}
