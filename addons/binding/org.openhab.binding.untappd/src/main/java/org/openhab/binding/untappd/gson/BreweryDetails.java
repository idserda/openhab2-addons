package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class BreweryDetails {

    @SerializedName("brewery_id")
    private Integer breweryId;

    public Integer getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(Integer breweryId) {
        this.breweryId = breweryId;
    }

}
