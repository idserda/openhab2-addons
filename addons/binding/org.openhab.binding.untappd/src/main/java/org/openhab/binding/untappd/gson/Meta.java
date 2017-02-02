
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("code")
    private Integer code;
    @SerializedName("response_time")
    private ResponseTime responseTime;
    @SerializedName("init_time")

    private InitTime initTime;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ResponseTime getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(ResponseTime responseTime) {
        this.responseTime = responseTime;
    }

    public InitTime getInitTime() {
        return initTime;
    }

    public void setInitTime(InitTime initTime) {
        this.initTime = initTime;
    }

}
