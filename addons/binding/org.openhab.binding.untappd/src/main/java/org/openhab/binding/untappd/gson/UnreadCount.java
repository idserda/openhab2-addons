
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class UnreadCount {

    @SerializedName("comments")
    private Integer comments;
    @SerializedName("toasts")
    private Integer toasts;
    @SerializedName("friends")
    private Integer friends;
    @SerializedName("messages")
    private Integer messages;
    @SerializedName("news")

    private Integer news;

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getToasts() {
        return toasts;
    }

    public void setToasts(Integer toasts) {
        this.toasts = toasts;
    }

    public Integer getFriends() {
        return friends;
    }

    public void setFriends(Integer friends) {
        this.friends = friends;
    }

    public Integer getMessages() {
        return messages;
    }

    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    public Integer getNews() {
        return news;
    }

    public void setNews(Integer news) {
        this.news = news;
    }

}
