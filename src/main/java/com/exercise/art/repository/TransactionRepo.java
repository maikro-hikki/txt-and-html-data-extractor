package com.exercise.art.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercise.art.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

	public List<Transaction> findByDate(String date);

	@Query("SELECT t FROM Transaction t LEFT JOIN Artwork a ON t.artwork.artworkId = a.artworkId LEFT JOIN Artist r ON a.artist.name = r.name WHERE r.name = :name AND t.date = :date")
	public List<Transaction> findByArtistNameAndDate(String name, String date);

	public List<Transaction> findByArtworkArtistName(String name);
}
