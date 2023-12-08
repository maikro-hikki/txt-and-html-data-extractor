package com.exercise.art.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.art.model.Artwork;
import com.exercise.art.repository.ArtworkRepo;

@Service
public class ArtworkService {

	@Autowired
	private ArtworkRepo artworkRepo;

	public Artwork addArtwork(Artwork artwork) {

		return artworkRepo.save(artwork);
	}

	public Optional<Artwork> findByName(String name) {

		return artworkRepo.findByName(name);
	}
	
	public Optional<Artwork> findByDescription(String description) {

		return artworkRepo.findByDescription(description);
	}
}
