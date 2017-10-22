
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("method")
    private String method;
    @SerializedName("mg")
    private Boolean mg;
    @SerializedName("checkins")
    private Checkins checkins;
    @SerializedName("pagination")
    private Pagination pagination;
    @SerializedName("news")
    private News news;
    @SerializedName("notifications")
    private NotificationItems notifications;
    @SerializedName("user")
    private User user;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Boolean getMg() {
        return mg;
    }

    public void setMg(Boolean mg) {
        this.mg = mg;
    }

    public Checkins getCheckins() {
        return checkins;
    }

    public void setCheckins(Checkins checkins) {
        this.checkins = checkins;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public NotificationItems getNotifications() {
        return notifications;
    }

    public void setNotifications(NotificationItems notifications) {
        this.notifications = notifications;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
