
package org.openhab.binding.untappd.gson;

import com.google.gson.annotations.SerializedName;

public class InitTime {

    @SerializedName("time")
    private Double time;
    @SerializedName("measure")
    private String measure;

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

}
