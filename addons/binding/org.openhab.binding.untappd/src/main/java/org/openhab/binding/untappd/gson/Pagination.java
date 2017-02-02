
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("next_url")
    private String nextUrl;
    @SerializedName("max_id")
    private Integer maxId;
    @SerializedName("since_url")

    private String sinceUrl;

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }

    public String getSinceUrl() {
        return sinceUrl;
    }

    public void setSinceUrl(String sinceUrl) {
        this.sinceUrl = sinceUrl;
    }

}
