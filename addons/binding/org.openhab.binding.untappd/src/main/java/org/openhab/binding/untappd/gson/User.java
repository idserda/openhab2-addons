
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("uid")
    private Integer uid;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("location")
    private String location;
    @SerializedName("url")
    private String url;
    @SerializedName("is_supporter")
    private Integer isSupporter;
    @SerializedName("relationship")
    private String relationship;
    @SerializedName("bio")
    private String bio;
    @SerializedName("user_avatar")
    private String userAvatar;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsSupporter() {
        return isSupporter;
    }

    public void setIsSupporter(Integer isSupporter) {
        this.isSupporter = isSupporter;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

}
