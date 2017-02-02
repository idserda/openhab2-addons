
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Location_ {

    @SerializedName("venue_address")
    private String venueAddress;
    @SerializedName("venue_city")
    private String venueCity;
    @SerializedName("venue_state")
    private String venueState;
    @SerializedName("venue_country")
    private String venueCountry;
    @SerializedName("lat")
    private Double lat;
    @SerializedName("lng")
    private Double lng;

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getVenueCity() {
        return venueCity;
    }

    public void setVenueCity(String venueCity) {
        this.venueCity = venueCity;
    }

    public String getVenueState() {
        return venueState;
    }

    public void setVenueState(String venueState) {
        this.venueState = venueState;
    }

    public String getVenueCountry() {
        return venueCountry;
    }

    public void setVenueCountry(String venueCountry) {
        this.venueCountry = venueCountry;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

}
