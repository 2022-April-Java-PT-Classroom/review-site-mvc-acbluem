package org.wecancoeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class ReviewController {

    @Resource
    private ReviewRepository reviewRepo;

    @RequestMapping("/reviews")
    public String findAllReviews(Model model) {
        model.addAttribute("reviewsModel", reviewRepo.findAll());
        model.addAttribute("review", new Review());
        return "reviewsTemplate";
    }

    @RequestMapping("/review")
    public String findOneReview(@RequestParam(value = "id") Long id, Model model) throws ReviewNotFoundException {

        if (reviewRepo.findOne(id) == null) {
            throw new ReviewNotFoundException();
        }

        model.addAttribute("reviewModel", reviewRepo.findOne(id));
        return "reviewTemplate";
    }

    @PostMapping("/reviews")
    public String createReview(@ModelAttribute Review review, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "param";
        }
        Review newReview = reviewRepo.createReview(review);
        reviewRepo.addToRepo(newReview);
        return "redirect:/reviews";
    }
}
