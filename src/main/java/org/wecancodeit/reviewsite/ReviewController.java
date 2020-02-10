package org.wecancodeit.reviewsite;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsite.ReviewNotFoundException;
import org.wecancodeit.reviewsite.ReviewRepository;

@RequestMapping("/show-reviews")
@Controller
public class ReviewController {

	@Resource
	private ReviewRepository reviewRepo;

	@GetMapping("") 
	public String findAllReviews(Model model) {

		model.addAttribute("reviewsModel", reviewRepo.findAllReviews()); 
		return "reviews-template"; // html file -- > Spring knows to go to my src/main/resources/templates + template name + .html
	}

	//new way with Path Variable - better for APIs
	@GetMapping("/{id}")
	public String findOneReview(@PathVariable(value = "id") Long id, Model model) throws ReviewNotFoundException{
		
		if(reviewRepo.findOneReview(id) == null) {
			throw new ReviewNotFoundException();
		}
		model.addAttribute("reviewModel", reviewRepo.findOneReview(id));
		return "review-template";
	}

}
