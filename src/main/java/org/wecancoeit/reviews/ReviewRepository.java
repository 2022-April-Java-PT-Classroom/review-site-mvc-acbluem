package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReviewRepository {
    Map<Long, Review> reviewsList = new HashMap<>();

    public ReviewRepository() {
        Review chase = new Review(1L, "Chase",
                "A bernese mountain dog that used to lay on top of me as a kid in the snow and I could not move. 10/10, was a very good boy.");
        Review dodger = new Review(2L, "Dodger",
                "A cocker spaniel that would take forever to bring back the ball because he'd always have to empty his bladder at the same time. 10/10, he deserved better.");
        Review hugs = new Review(3L, "Hugs",
                "A long-haired calico cat with the sweetest temperament and would try to lay on anyone's lap or feet. 10/10, she was the cuddliest cat.");
        Review marble = new Review(4L, "Marble",
                "A short-haired tortoiseshell cat shy in nature but loved attention. 10/10, was not as spoiled as Hugs and that was a crime.");

        reviewsList.put(chase.getId(), chase);
        reviewsList.put(dodger.getId(), dodger);
        reviewsList.put(hugs.getId(), hugs);
        reviewsList.put(marble.getId(), marble);
    }

    public ReviewRepository(Review... reviewToAdd) {
        for (Review review : reviewToAdd) {
            reviewsList.put(review.getId(), review);
        }
    }

    public Review findOne(long id) {
        return reviewsList.get(id);
    }

    public Collection<Review> findAll() {
        return reviewsList.values();
    }
}
