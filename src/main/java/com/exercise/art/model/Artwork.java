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
public class Artwork {

	@Id
	@GeneratedValue
	private long artworkId;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_artistId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Artist artist;

	public Artwork() {
	}

	public Artwork(long artworkId, String name, Artist artist) {
		this.artworkId = artworkId;
		this.name = name;
		this.artist = artist;
	}

	public long getArtworkId() {
		return artworkId;
	}

	public void setArtworkId(long artworkId) {
		this.artworkId = artworkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
}
