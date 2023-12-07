package com.exercise.art.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Buyer {
	
	@Id
	@GeneratedValue
	private long buyerId;
	
	private String name;
	
	private String address;

	public Buyer() {
	}

	public Buyer(long buyerId, String name, String address) {
		this.buyerId = buyerId;
		this.name = name;
		this.address = address;
	}

	public long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
