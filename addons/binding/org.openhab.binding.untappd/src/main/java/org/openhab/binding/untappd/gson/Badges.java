
package org.openhab.binding.untappd.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Badges {

    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<Item___> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item___> getItems() {
        return items;
    }

    public void setItems(List<Item___> items) {
        this.items = items;
    }

}
