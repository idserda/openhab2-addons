
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Foursquare {

    @SerializedName("foursquare_id")
    private String foursquareId;
    @SerializedName("foursquare_url")
    private String foursquareUrl;

    public String getFoursquareId() {
        return foursquareId;
    }

    public void setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
    }

    public String getFoursquareUrl() {
        return foursquareUrl;
    }

    public void setFoursquareUrl(String foursquareUrl) {
        this.foursquareUrl = foursquareUrl;
    }

}
