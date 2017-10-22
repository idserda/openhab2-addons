package org.openhab.binding.untappd.gson.oauth;

import com.google.gson.annotations.SerializedName;

public class Authorize {

    @SerializedName("response")
    private AuthResponse response;

    public AuthResponse getResponse() {
        return response;
    }

    public void setResponse(AuthResponse response) {
        this.response = response;
    }

}
