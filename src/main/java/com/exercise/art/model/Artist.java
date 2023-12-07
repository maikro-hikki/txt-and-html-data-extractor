package com.exercise.art.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private long artistId;
	
	private String name;	

	public Artist() {
	}

	public Artist(long artistId, String name) {
		this.artistId = artistId;
		this.name = name;
	}

	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
