
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Contact_ {

    @SerializedName("twitter")
    private String twitter;
    @SerializedName("venue_url")
    private String venueUrl;

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getVenueUrl() {
        return venueUrl;
    }

    public void setVenueUrl(String venueUrl) {
        this.venueUrl = venueUrl;
    }

}
