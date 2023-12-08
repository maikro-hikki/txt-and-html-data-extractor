package com.exercise.art.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exercise.art.model.Artwork;
import com.exercise.art.service.ArtworkService;

@Controller
public class InformationController {
	
	@Autowired
	private ArtworkService artworkService;
	
	@GetMapping("/summaryPage")
	public String summary(Model model) {
		
		List<Artwork> davidArtTotal = artworkService.findByArtistName("David");
		model.addAttribute("davidArtTotal", davidArtTotal.size());
		
		return "summaryPage";
	}

}
