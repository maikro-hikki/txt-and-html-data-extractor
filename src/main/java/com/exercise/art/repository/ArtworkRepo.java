package com.exercise.art.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.art.model.Artwork;

@Repository
public interface ArtworkRepo extends JpaRepository<Artwork, Long>{
	
	public Optional<Artwork> findByName(String name);
	
	public Optional<Artwork> findByDescription(String description);

}
