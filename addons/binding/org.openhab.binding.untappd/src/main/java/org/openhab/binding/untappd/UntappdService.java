package org.openhab.binding.untappd;

import org.openhab.binding.untappd.gson.Recent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UntappdService {

    @GET("v4/checkin/recent")
    Call<Recent> recent(@Query("access_token") String access_token, @Query("min_id") Integer min_id);

}
