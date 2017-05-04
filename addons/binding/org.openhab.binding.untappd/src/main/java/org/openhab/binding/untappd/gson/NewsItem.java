
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsItem {

    @SerializedName("news_id")
    @Expose
    private Integer newsId;
    @SerializedName("news_title")
    @Expose
    private String newsTitle;
    @SerializedName("news_link")
    @Expose
    private String newsLink;
    @SerializedName("news_text")
    @Expose
    private String newsText;
    @SerializedName("news_image_link")
    @Expose
    private String newsImageLink;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("news_type")
    @Expose
    private String newsType;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public String getNewsImageLink() {
        return newsImageLink;
    }

    public void setNewsImageLink(String newsImageLink) {
        this.newsImageLink = newsImageLink;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

}
