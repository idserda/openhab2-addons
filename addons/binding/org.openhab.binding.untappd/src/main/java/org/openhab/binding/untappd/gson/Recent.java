
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Recent {

    @SerializedName("meta")
    private Meta meta;
    @SerializedName("notifications")
    private Notifications notifications;
    @SerializedName("response")

    private Response response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Notifications getNotifications() {
        return notifications;
    }

    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
