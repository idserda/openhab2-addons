
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Item___ {

    @SerializedName("badge_id")
    private Integer badgeId;
    @SerializedName("user_badge_id")
    private Integer userBadgeId;
    @SerializedName("badge_name")
    private String badgeName;
    @SerializedName("badge_description")
    private String badgeDescription;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("badge_image")

    private BadgeImage badgeImage;

    public Integer getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Integer badgeId) {
        this.badgeId = badgeId;
    }

    public Integer getUserBadgeId() {
        return userBadgeId;
    }

    public void setUserBadgeId(Integer userBadgeId) {
        this.userBadgeId = userBadgeId;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getBadgeDescription() {
        return badgeDescription;
    }

    public void setBadgeDescription(String badgeDescription) {
        this.badgeDescription = badgeDescription;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public BadgeImage getBadgeImage() {
        return badgeImage;
    }

    public void setBadgeImage(BadgeImage badgeImage) {
        this.badgeImage = badgeImage;
    }

}
