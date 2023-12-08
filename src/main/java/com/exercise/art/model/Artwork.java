package com.exercise.art.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
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
	
	private String date;
	
	@Column(unique = true)
	private String description;

	public Artwork() {
	}

	public Artwork(String name, Artist artist, String date, String description) {
		this.name = name;
		this.artist = artist;
		this.date = date;
		this.description = description;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
