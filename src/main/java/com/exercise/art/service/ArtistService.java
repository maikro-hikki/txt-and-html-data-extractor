package com.exercise.art.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.art.model.Artist;
import com.exercise.art.repository.ArtistRepo;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepo artistRepo;

	public Artist addArtist(Artist artist) {

		return artistRepo.save(artist);
	}

	public boolean artistExist(String name) {

		Artist artist = artistRepo.findByName(name).orElse(null);

		if (artist == null) {
			return false;
		}
		return true;
	}

	public Optional<Artist> findByName(String name) {

		return artistRepo.findByName(name);
	}

}
