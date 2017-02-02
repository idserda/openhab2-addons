
package org.openhab.binding.untappd.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Comments {

    @SerializedName("total_count")
    private Integer totalCount;
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<Object> items = new ArrayList<>();

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

}
