
package org.openhab.binding.untappd.gson;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("checkin_id")
    private Integer checkinId;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("checkin_comment")
    private String checkinComment;
    @SerializedName("rating_score")
    private Double ratingScore;
    @SerializedName("user")
    private User user;
    @SerializedName("beer")
    private Beer beer;
    @SerializedName("brewery")
    private Brewery brewery;
    @SerializedName("venue")

    private Venue venue;
    @SerializedName("comments")
    private Comments comments;
    @SerializedName("toasts")
    private Toasts toasts;
    @SerializedName("media")
    private Media media;
    @SerializedName("source")
    private Source source;
    @SerializedName("badges")
    private Badges badges;

    public Integer getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(Integer checkinId) {
        this.checkinId = checkinId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCheckinComment() {
        return checkinComment;
    }

    public void setCheckinComment(String checkinComment) {
        this.checkinComment = checkinComment;
    }

    public Double getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(Double ratingScore) {
        this.ratingScore = ratingScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Toasts getToasts() {
        return toasts;
    }

    public void setToasts(Toasts toasts) {
        this.toasts = toasts;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Badges getBadges() {
        return badges;
    }

    public void setBadges(Badges badges) {
        this.badges = badges;
    }

}
