
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Brewery {

    @SerializedName("brewery_id")
    private Integer breweryId;
    @SerializedName("brewery_name")
    private String breweryName;
    @SerializedName("brewery_slug")
    private String brewerySlug;
    @SerializedName("brewery_label")
    private String breweryLabel;
    @SerializedName("country_name")
    private String countryName;
    @SerializedName("contact")
    private Contact contact;
    @SerializedName("location")
    private Location location;
    @SerializedName("brewery_active")
    private Integer breweryActive;

    public Integer getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(Integer breweryId) {
        this.breweryId = breweryId;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getBrewerySlug() {
        return brewerySlug;
    }

    public void setBrewerySlug(String brewerySlug) {
        this.brewerySlug = brewerySlug;
    }

    public String getBreweryLabel() {
        return breweryLabel;
    }

    public void setBreweryLabel(String breweryLabel) {
        this.breweryLabel = breweryLabel;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getBreweryActive() {
        return breweryActive;
    }

    public void setBreweryActive(Integer breweryActive) {
        this.breweryActive = breweryActive;
    }

}
