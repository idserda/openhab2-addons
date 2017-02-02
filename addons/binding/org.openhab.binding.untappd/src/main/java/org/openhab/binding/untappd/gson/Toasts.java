
package org.openhab.binding.untappd.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Toasts {

    @SerializedName("total_count")
    private Integer totalCount;
    @SerializedName("count")
    private Integer count;
    @SerializedName("auth_toast")
    private Boolean authToast;
    @SerializedName("items")
    private List<Item__> items = new ArrayList<>();

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

    public Boolean getAuthToast() {
        return authToast;
    }

    public void setAuthToast(Boolean authToast) {
        this.authToast = authToast;
    }

    public List<Item__> getItems() {
        return items;
    }

    public void setItems(List<Item__> items) {
        this.items = items;
    }

}
