package org.wecancodeit.reviewsite;

//import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.wecancodeit.reviewsite.Review;
import org.wecancodeit.reviewsite.ReviewRepository;

class ReviewsRepositoryTest {

	@Resource
	private ReviewRepository underTest;
	private Review reviewOne = new Review(1L, "review 1 title", "description", "imageURL", "category", "date");
	private Review reviewTwo = new Review(2L, "review 2 title", "description", "imageURL", "category", "date");
	
	@Test
	public void shouldReturnReviewOneById() {
		underTest = new ReviewRepository(reviewOne);
		Review foundReview = underTest.findOneReview(1L);
		assertEquals(foundReview, reviewOne);
	}
	@Test
	public void shouldReturnReviewTwoById() {
		underTest = new ReviewRepository(reviewTwo);
		Review foundReview = underTest.findOneReview(2L);
		assertEquals(foundReview, reviewTwo);

	}

	@Test
	public void shouldFindAllReviews() {
		underTest = new ReviewRepository(reviewOne, reviewTwo);
		Collection<Review> foundReviews = underTest.findAllReviews();
		assertTrue(foundReviews.contains(reviewOne));
		assertTrue(foundReviews.contains(reviewTwo));


	}

}
