package org.openhab.binding.untappd.internal;

public class UntappdConfiguration {

    private String access_token;

    private Boolean filter_self = false;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Boolean getFilter_self() {
        return filter_self;
    }

    public void setFilter_self(Boolean filter_self) {
        this.filter_self = filter_self;
    }

}
