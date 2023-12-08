package com.exercise.art;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.exercise.art.model.Artist;
import com.exercise.art.model.Artwork;
import com.exercise.art.model.Buyer;
import com.exercise.art.model.Transaction;
import com.exercise.art.service.ArtistService;
import com.exercise.art.service.ArtworkService;
import com.exercise.art.service.BuyerService;
import com.exercise.art.service.TransactionService;

@Component
public class DataInit implements ApplicationRunner {

	@Autowired
	private ArtistService artistService;

	@Autowired
	private ArtworkService artworkService;

	@Autowired
	private BuyerService buyerService;

	@Autowired
	private TransactionService transactionService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

/////////////Start: extract info about artist and artwork/////////////////////////////////		
		String filePath1 = "src/main/resources/static/productlist-readonly.txt";

		String delimiter = "-";
		String extension = ".jpg";

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath1))) {
			String line;

			while ((line = reader.readLine()) != null) {

				Artwork foundWork = artworkService.findByDescription(line).orElse(null);

				if (!(foundWork == null)) {

					continue;
				}

				String formatted = line.replace(extension, "");

				String[] parts = formatted.split(delimiter);

				if (!artistService.artistExist(parts[2])) {

					Artist artist = new Artist(parts[2]);
					artistService.addArtist(artist);
				}

				Artist artist = artistService.findByName(parts[2]).orElse(null);
				Artwork artwork = new Artwork(parts[1], artist, parts[0], line);

				artworkService.addArtwork(artwork);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
/////////////////////End: extract info about artist and artwork///////////////////////////

///////////////////////////Start: loop through each order#.html//////////////////////////////////////////////////

		for (int j = 1; j < 5; j++) {

			String basePath = "src/main/resources/static/";

			String fileName = "order" + j + ".html";

			String filePath2 = basePath + fileName;

//////////////////Start: extract information about buyer and transaction/////////////////////////////////////////		

			StringBuilder html = new StringBuilder();

			Buyer buyer = new Buyer();

			try (BufferedReader reader = new BufferedReader(new FileReader(filePath2))) {
				String line;
				while ((line = reader.readLine()) != null) {
					html.append(line);
				}

				String result = html.toString();

				String patternString1 = "<span id=\"buyerName\">(.*?)</span>";
				Pattern pattern1 = Pattern.compile(patternString1);
				Matcher matcher1 = pattern1.matcher(result);

				if (matcher1.find()) {
					String extractedValue = matcher1.group(1);
					buyer.setName(extractedValue);
				}

				String patternString2 = "<span id=\"buyerAddress\">(.*?)</span>";
				Pattern pattern2 = Pattern.compile(patternString2);
				Matcher matcher2 = pattern2.matcher(result);

				if (matcher2.find()) {
					String extractedValue = matcher2.group(1);
					buyer.setAddress(extractedValue);
				}

				Buyer savedBuyer = buyerService.addBuyer(buyer);

/////////////////////////////Start: add information about transaction////////////////////////////

				File htmlFile = new File(filePath2);

				try {
					// Load the HTML file and create a Document object
					Document doc = Jsoup.parse(htmlFile, "UTF-8");

					// Get all the <p> elements
					Elements paragraphs = doc.select("div");

					for (int i = 1; i < paragraphs.size(); i++) {

						Transaction transaction = new Transaction();
						transaction.setBuyer(savedBuyer);

						String[] part = paragraphs.get(i).text().split(" ");
						// handle artwork
						String artName = part[0].replace(extension, "");
						String[] artNamePart = artName.split("-");
						Artwork artwork = artworkService.findByDescription(part[0]).orElse(null);

						transaction.setArtwork(artwork);
						// handle date
						transaction.setDate(artNamePart[0]);

						// handle price
						String price = part[2].replace("$", "");
						Double priceDouble = Double.parseDouble(price);
						transaction.setPrice(priceDouble);

						// save transaction
						transactionService.addTransaction(transaction);
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

//////////////////////////End: add information about transaction////////////////////////////

/////////////////////////End: extract information about buyer and transaction/////////////////

				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

/////////////////////////////////////////End: loop through each order#.html/////////////////////

/////////////////////End: extract info about artist and artwork///////////////////////////

		}
///////////////////////////Start: get info for submittedorder.html//////////////////////////////////////////////////

		String filePath3 = "src/main/resources/static/submittedorder.html";

//////////////////Start: extract information about buyer and transaction/////////////////////////////////////////		

		StringBuilder html2 = new StringBuilder();

		Buyer buyer2 = new Buyer();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath3))) {
			String line;
			while ((line = reader.readLine()) != null) {
				html2.append(line);
			}

			String result = html2.toString();

			String patternString1 = "<span id=\"buyerName\">(.*?)</span>";
			Pattern pattern1 = Pattern.compile(patternString1);
			Matcher matcher1 = pattern1.matcher(result);

			if (matcher1.find()) {
				String extractedValue = matcher1.group(1);
				buyer2.setName(extractedValue);
			}

			String patternString2 = "<span id=\"buyerAddress\">(.*?)</span>";
			Pattern pattern2 = Pattern.compile(patternString2);
			Matcher matcher2 = pattern2.matcher(result);

			if (matcher2.find()) {
				String extractedValue = matcher2.group(1);
				buyer2.setAddress(extractedValue);
			}

			Buyer savedBuyer = buyerService.addBuyer(buyer2);

/////////////////////////////Start: add information about transaction////////////////////////////

			File html2File = new File(filePath3);

			try {
				// Load the html2 file and create a Document object
				Document doc = Jsoup.parse(html2File, "UTF-8");

				// Get all the <p> elements
				Elements paragraphs = doc.select("div");

				for (int i = 1; i < paragraphs.size(); i++) {

					Transaction transaction = new Transaction();
					transaction.setBuyer(savedBuyer);

					String[] part = paragraphs.get(i).text().split(" ");
					// handle artwork
					String artName = part[0].replace(extension, "");
					String[] artNamePart = artName.split("-");
					Artwork artwork = artworkService.findByDescription(part[0]).orElse(null);

					transaction.setArtwork(artwork);
					// handle date
					transaction.setDate(artNamePart[0]);

					// handle price
					String price = part[2].replace("$", "");
					Double priceDouble = Double.parseDouble(price);
					transaction.setPrice(priceDouble);

					// save transaction
					transactionService.addTransaction(transaction);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

//////////////////////////End: add information about transaction////////////////////////////

/////////////////////////End: extract information about buyer and transaction/////////////////

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

/////////////////////////////////////////End: get info for submittedorder.html2/////////////////////
	}

}
