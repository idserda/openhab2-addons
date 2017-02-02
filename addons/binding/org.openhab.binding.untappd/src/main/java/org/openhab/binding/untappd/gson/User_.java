
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class User_ {

    @SerializedName("uid")
    private Integer uid;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("bio")
    private String bio;
    @SerializedName("location")
    private String location;
    @SerializedName("user_avatar")
    private String userAvatar;
    @SerializedName("account_type")
    private String accountType;
    @SerializedName("venue_details")
    private VenueDetails venueDetails;
    @SerializedName("brewery_details")
    private BreweryDetails breweryDetails;
    @SerializedName("user_link")

    private String userLink;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public VenueDetails getVenueDetails() {
        return venueDetails;
    }

    public void setVenueDetails(VenueDetails venueDetails) {
        this.venueDetails = venueDetails;
    }

    public BreweryDetails getBreweryDetails() {
        return breweryDetails;
    }

    public void setBreweryDetails(BreweryDetails breweryDetails) {
        this.breweryDetails = breweryDetails;
    }

    public String getUserLink() {
        return userLink;
    }

    public void setUserLink(String userLink) {
        this.userLink = userLink;
    }

}
