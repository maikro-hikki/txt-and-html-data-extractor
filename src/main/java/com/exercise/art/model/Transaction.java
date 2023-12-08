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
	@JoinColumn(name = "fk_buyerId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Buyer buyer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_artworkId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Artwork artwork;

	public Transaction() {
	}

	public Transaction(long transactionId, double price, String date, Buyer buyer, Artwork artwork) {
		super();
		this.transactionId = transactionId;
		this.price = price;
		this.date = date;
		this.buyer = buyer;
		this.artwork = artwork;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}
	
}
