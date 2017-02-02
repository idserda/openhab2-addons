
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("app_name")
    private String appName;
    @SerializedName("app_website")
    private String appWebsite;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppWebsite() {
        return appWebsite;
    }

    public void setAppWebsite(String appWebsite) {
        this.appWebsite = appWebsite;
    }

}
