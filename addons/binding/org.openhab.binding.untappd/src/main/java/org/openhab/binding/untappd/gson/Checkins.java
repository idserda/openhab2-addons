
package org.openhab.binding.untappd.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Checkins {

    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<Item> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
