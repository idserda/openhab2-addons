
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Item__ {

    @SerializedName("uid")
    private Integer uid;
    @SerializedName("user")
    private User_ user;
    @SerializedName("like_id")
    private Integer likeId;
    @SerializedName("like_owner")
    private Boolean likeOwner;
    @SerializedName("created_at")
    private String createdAt;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Boolean getLikeOwner() {
        return likeOwner;
    }

    public void setLikeOwner(Boolean likeOwner) {
        this.likeOwner = likeOwner;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
