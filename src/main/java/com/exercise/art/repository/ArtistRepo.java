package com.exercise.art.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.art.model.Artist;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Long>{
	
	Optional<Artist> findByName(String name);

}
