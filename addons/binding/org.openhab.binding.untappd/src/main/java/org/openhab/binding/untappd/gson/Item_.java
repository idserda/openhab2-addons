
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Item_ {

    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("category_id")
    private String categoryId;
    @SerializedName("is_primary")
    private Boolean isPrimary;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

}
