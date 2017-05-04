
package org.openhab.binding.untappd.gson;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationItems {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<NotificationItem> items = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<NotificationItem> getItems() {
        return items;
    }

    public void setItems(List<NotificationItem> items) {
        this.items = items;
    }

}
