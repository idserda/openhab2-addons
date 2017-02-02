
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Notifications {

    @SerializedName("type")
    private String type;
    @SerializedName("unread_count")
    private UnreadCount unreadCount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UnreadCount getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(UnreadCount unreadCount) {
        this.unreadCount = unreadCount;
    }

}
