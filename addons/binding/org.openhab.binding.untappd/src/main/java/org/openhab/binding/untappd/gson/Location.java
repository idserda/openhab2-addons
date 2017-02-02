
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("brewery_city")
    private String breweryCity;
    @SerializedName("brewery_state")
    private String breweryState;
    @SerializedName("lat")
    private Double lat;
    @SerializedName("lng")
    private Double lng;

    public String getBreweryCity() {
        return breweryCity;
    }

    public void setBreweryCity(String breweryCity) {
        this.breweryCity = breweryCity;
    }

    public String getBreweryState() {
        return breweryState;
    }

    public void setBreweryState(String breweryState) {
        this.breweryState = breweryState;
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
