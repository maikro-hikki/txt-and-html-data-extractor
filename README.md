# HTML Data Extractor
- A Spring Boot application to experiment with extraction, pre-processing, and summarization of data from text and HTML files
- The example scenario for this project is of an artwork order system and the output summarizes the HTML pages of the orders that have been made on different days
---
### Tech stack used:
- Spring Boot
- Thymeleaf
- H2 in-memory Database (for demonstration purpose)
- HTML and CSS (for displaying the output summary)
---
### Logical process:
- The text file `productlist-readonly.txt` stores information such as artwork name, artist, and date
- The application scans the text file and organizes the data into Artist and Artwork entities and store them into the database
- The application then scans the HTML files `order(1-4).html` and `submittedorder.html` and organizes the data into Buyer and Transaction entities and store them into the database
- Information related to how many artworks each artist sold each day is summarized and the output is shown in a table using HTML and CSS
- A few elements were hardcoded in the output, namely artist names and dates, as the project was just to practice data extraction and organization in a controlled environment
---
### Quick start:
- To start the program, go into the project folder and use the command line `mvn spring-boot:run`
- To stop the program, just Ctrl-C
- To view the data summary, open the browser and use the url `localhost:9001/summaryPage`
