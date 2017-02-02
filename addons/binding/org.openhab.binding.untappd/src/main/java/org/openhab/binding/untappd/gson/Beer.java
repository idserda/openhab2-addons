
package org.openhab.binding.untappd.gson;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class Beer {

    @SerializedName("bid")
    private Integer bid;
    @SerializedName("beer_name")
    private String beerName;
    @SerializedName("beer_label")
    private String beerLabel;
    @SerializedName("beer_slug")
    private String beerSlug;
    @SerializedName("beer_style")
    private String beerStyle;
    @SerializedName("beer_abv")
    private BigDecimal beerAbv;
    @SerializedName("auth_rating")
    private BigDecimal authRating;
    @SerializedName("wish_list")
    private Boolean wishList;
    @SerializedName("beer_active")

    private Integer beerActive;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBeerLabel() {
        return beerLabel;
    }

    public void setBeerLabel(String beerLabel) {
        this.beerLabel = beerLabel;
    }

    public String getBeerSlug() {
        return beerSlug;
    }

    public void setBeerSlug(String beerSlug) {
        this.beerSlug = beerSlug;
    }

    public String getBeerStyle() {
        return beerStyle;
    }

    public void setBeerStyle(String beerStyle) {
        this.beerStyle = beerStyle;
    }

    public BigDecimal getBeerAbv() {
        return beerAbv;
    }

    public void setBeerAbv(BigDecimal beerAbv) {
        this.beerAbv = beerAbv;
    }

    public BigDecimal getAuthRating() {
        return authRating;
    }

    public void setAuthRating(BigDecimal authRating) {
        this.authRating = authRating;
    }

    public Boolean getWishList() {
        return wishList;
    }

    public void setWishList(Boolean wishList) {
        this.wishList = wishList;
    }

    public Integer getBeerActive() {
        return beerActive;
    }

    public void setBeerActive(Integer beerActive) {
        this.beerActive = beerActive;
    }

}
