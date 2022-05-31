package org.wecancoeit.reviews;

public class Review {
    private Long id;
    private String name;
    private String verdict;

    public Review(long id, String name, String verdict) {
        this.id = id;
        this.name = name;
        this.verdict = verdict;
    }

    public Review() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVerdict() {
        return verdict;
    }
}
