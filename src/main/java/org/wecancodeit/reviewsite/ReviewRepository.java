package org.wecancodeit.reviewsite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviewsite.Review;;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	private Review reviewOne = new Review(1L, "VooDoo Brewery: EctoCooler", "/images/green-beer.jpg", "Category: Experimental Sour", "Fruity, green, and kinda weird", "1/11/2020");
	private Review reviewTwo = new Review(2L, "VooDoo Brewery: BBVDD Imperial Stout", "/images/VooDoo-BBVD-beer.jpg", "Category: Imperial Stout","Full-bodied, sweet, and high ABV", "2/2/2020");
	
	
	
	public ReviewRepository() {
		reviewList.put(reviewOne.getId(), reviewOne);
		reviewList.put(reviewTwo.getId(), reviewTwo);
		
	}

	public ReviewRepository(Review... reviews) {
		for (Review review : reviews) {
			reviewList.put(review.getId(), review); // grabs each singular class and adds it to the database
		}
	}
	
	
	public Review findOneReview(long id) {
		return reviewList.get(id);
	}


	public Collection<Review> findAllReviews() {
		return reviewList.values();
	}
	
}
