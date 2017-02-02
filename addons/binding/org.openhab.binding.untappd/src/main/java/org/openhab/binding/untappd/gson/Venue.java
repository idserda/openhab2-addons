
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Venue {

    @SerializedName("venue_id")
    private Integer venueId;
    @SerializedName("venue_name")
    private String venueName;
    @SerializedName("venue_slug")
    private String venueSlug;
    @SerializedName("primary_category")
    private String primaryCategory;
    @SerializedName("parent_category_id")
    private String parentCategoryId;
    @SerializedName("categories")
    private Categories categories;
    @SerializedName("location")
    private Location_ location;
    @SerializedName("contact")
    private Contact_ contact;
    @SerializedName("public_venue")
    private Boolean publicVenue;
    @SerializedName("foursquare")
    private Foursquare foursquare;
    @SerializedName("venue_icon")
    private VenueIcon venueIcon;
    @SerializedName("is_verified")
    private Boolean isVerified;

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueSlug() {
        return venueSlug;
    }

    public void setVenueSlug(String venueSlug) {
        this.venueSlug = venueSlug;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Location_ getLocation() {
        return location;
    }

    public void setLocation(Location_ location) {
        this.location = location;
    }

    public Contact_ getContact() {
        return contact;
    }

    public void setContact(Contact_ contact) {
        this.contact = contact;
    }

    public Boolean getPublicVenue() {
        return publicVenue;
    }

    public void setPublicVenue(Boolean publicVenue) {
        this.publicVenue = publicVenue;
    }

    public Foursquare getFoursquare() {
        return foursquare;
    }

    public void setFoursquare(Foursquare foursquare) {
        this.foursquare = foursquare;
    }

    public VenueIcon getVenueIcon() {
        return venueIcon;
    }

    public void setVenueIcon(VenueIcon venueIcon) {
        this.venueIcon = venueIcon;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

}
