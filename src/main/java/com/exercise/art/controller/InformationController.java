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
		
		List<Transaction> david9Sold = transactionService.findByArtistNameAndDate("David", "09Dec");		
		model.addAttribute("david9Sold", david9Sold.size());
		
		List<Transaction> frank9Sold = transactionService.findByArtistNameAndDate("Frank", "09Dec");
		model.addAttribute("frank9Sold", frank9Sold.size());
		
		List<Transaction> james9Sold = transactionService.findByArtistNameAndDate("James", "09Dec");
		model.addAttribute("james9Sold", james9Sold.size());
		
		List<Transaction> lynn9Sold = transactionService.findByArtistNameAndDate("Lynn", "09Dec");
		model.addAttribute("lynn9Sold", lynn9Sold.size());
		
		List<Transaction> sam9Sold = transactionService.findByArtistNameAndDate("Sam", "09Dec");
		model.addAttribute("sam9Sold", sam9Sold.size());
		
		List<Transaction> david10Sold = transactionService.findByArtistNameAndDate("David", "10Dec");
		model.addAttribute("david10Sold", david10Sold.size());
		
		List<Transaction> frank10Sold = transactionService.findByArtistNameAndDate("Frank", "10Dec");
		model.addAttribute("frank10Sold", frank10Sold.size());
		
		List<Transaction> james10Sold = transactionService.findByArtistNameAndDate("James", "10Dec");
		model.addAttribute("james10Sold", james10Sold.size());
		
		List<Transaction> lynn10Sold = transactionService.findByArtistNameAndDate("Lynn", "10Dec");
		model.addAttribute("lynn10Sold", lynn10Sold.size());
		
		List<Transaction> sam10Sold = transactionService.findByArtistNameAndDate("Sam", "10Dec");
		model.addAttribute("sam10Sold", sam10Sold.size());
		
		List<Transaction> david11Sold = transactionService.findByArtistNameAndDate("David", "11Dec");
		model.addAttribute("david11Sold", david11Sold.size());
		
		List<Transaction> frank11Sold = transactionService.findByArtistNameAndDate("Frank", "11Dec");
		model.addAttribute("frank11Sold", frank11Sold.size());
		
		List<Transaction> james11Sold = transactionService.findByArtistNameAndDate("James", "11Dec");
		model.addAttribute("james11Sold", james11Sold.size());
		
		List<Transaction> lynn11Sold = transactionService.findByArtistNameAndDate("Lynn", "11Dec");
		model.addAttribute("lynn11Sold", lynn11Sold.size());
		
		List<Transaction> sam11Sold = transactionService.findByArtistNameAndDate("Sam", "11Dec");
		model.addAttribute("sam11Sold", sam11Sold.size());
		
		List<Transaction> davidTotalSold = transactionService.findByArtistName("David");
		model.addAttribute("davidTotalSold", davidTotalSold.size());
		
		List<Transaction> frankTotalSold = transactionService.findByArtistName("Frank");
		model.addAttribute("frankTotalSold", frankTotalSold.size());
		
		List<Transaction> jamesTotalSold = transactionService.findByArtistName("James");
		model.addAttribute("jamesTotalSold", jamesTotalSold.size());
		
		List<Transaction> lynnTotalSold = transactionService.findByArtistName("Lynn");
		model.addAttribute("lynnTotalSold", lynnTotalSold.size());
		
		List<Transaction> samTotalSold = transactionService.findByArtistName("Sam");
		model.addAttribute("samTotalSold", samTotalSold.size());
		
		return "summaryPage";
	}

}
