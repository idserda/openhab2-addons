
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class BadgeImage {

    @SerializedName("sm")
    private String sm;
    @SerializedName("md")
    private String md;
    @SerializedName("lg")

    private String lg;

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getLg() {
        return lg;
    }

    public void setLg(String lg) {
        this.lg = lg;
    }

}
