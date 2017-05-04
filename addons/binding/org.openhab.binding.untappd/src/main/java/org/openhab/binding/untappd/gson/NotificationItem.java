
package org.openhab.binding.untappd.gson;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationItem {

    @SerializedName("notification_type")
    @Expose
    private String notificationType;
    @SerializedName("message")
    @Expose
    private Object message;
    @SerializedName("notification_created_at")
    @Expose
    private Date notificationCreatedAt;
    @SerializedName("created_at")
    @Expose
    private Date createdAt;
    @SerializedName("checkin_created_at")
    @Expose
    private Date checkinCreatedAt;
    @SerializedName("checkin_id")
    @Expose
    private Integer checkinId;
    @SerializedName("checkin_comment")
    @Expose
    private String checkinComment;
    @SerializedName("rating_score")
    @Expose
    private Double ratingScore;
    @SerializedName("checkin_owner")
    @Expose
    private Boolean checkinOwner;
    @SerializedName("actor")
    @Expose
    private Actor actor;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("beer")
    @Expose
    private Beer beer;
    @SerializedName("brewery")
    @Expose
    private Brewery brewery;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("comments")
    @Expose
    private Comments comments;
    @SerializedName("toasts")
    @Expose
    private Toasts toasts;
    @SerializedName("media")
    @Expose
    private Media media;
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("badges")
    @Expose
    private Badges badges;

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Date getNotificationCreatedAt() {
        return notificationCreatedAt;
    }

    public void setNotificationCreatedAt(Date notificationCreatedAt) {
        this.notificationCreatedAt = notificationCreatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCheckinCreatedAt() {
        return checkinCreatedAt;
    }

    public void setCheckinCreatedAt(Date checkinCreatedAt) {
        this.checkinCreatedAt = checkinCreatedAt;
    }

    public Integer getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(Integer checkinId) {
        this.checkinId = checkinId;
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

    public Boolean getCheckinOwner() {
        return checkinOwner;
    }

    public void setCheckinOwner(Boolean checkinOwner) {
        this.checkinOwner = checkinOwner;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
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
