package com.exercise.art.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exercise.art.model.Artwork;
import com.exercise.art.model.Transaction;
import com.exercise.art.service.ArtworkService;
import com.exercise.art.service.TransactionService;

@Controller
public class InformationController {
	
	@Autowired
	private ArtworkService artworkService;
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/summaryPage")
	public String summary(Model model) {
		
		List<Artwork> davidArtTotal = artworkService.findByArtistName("David");
		model.addAttribute("davidArtTotal", davidArtTotal.size());
		
		List<Artwork> frankArtTotal = artworkService.findByArtistName("Frank");
		model.addAttribute("frankArtTotal", frankArtTotal.size());
		
		List<Artwork> jamesArtTotal = artworkService.findByArtistName("James");
		model.addAttribute("jamesArtTotal", jamesArtTotal.size());
		
		List<Artwork> lynnArtTotal = artworkService.findByArtistName("Lynn");
		model.addAttribute("lynnArtTotal", lynnArtTotal.size());
		
		List<Artwork> samArtTotal = artworkService.findByArtistName("Sam");
		model.addAttribute("samArtTotal", samArtTotal.size());
		
		List<Transaction> dec9Sold = transactionService.findByDate("09Dec");
		model.addAttribute("dec9Sold", dec9Sold.size());
		
		List<Transaction> dec10Sold = transactionService.findByDate("10Dec");
		model.addAttribute("dec10Sold", dec10Sold.size());
		
		List<Transaction> dec11Sold = transactionService.findByDate("11Dec");
		model.addAttribute("dec11Sold", dec11Sold.size());
		
		List<Transaction> david9Sold = transactionService.findByArtistNameAndDate("Daved", "09Dec");
		model.addAttribute("david9Sold", david9Sold.size());
		
		return "summaryPage";
	}

}
