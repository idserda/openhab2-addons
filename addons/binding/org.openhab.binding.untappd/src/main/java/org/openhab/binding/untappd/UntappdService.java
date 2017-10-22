package org.openhab.binding.untappd;

import org.openhab.binding.untappd.gson.Recent;
import org.openhab.binding.untappd.gson.oauth.Authorize;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UntappdService {

    @GET("v4/checkin/recent")
    Call<Recent> recent(@Query("access_token") String accessToken, @Query("min_id") Integer minId,
            @Query("limit") Integer limit);

    @GET("v4/notifications")
    Call<Recent> notifications(@Query("access_token") String accessToken, @Query("limit") Integer limit);

    @GET("/v4/user/info")
    Call<Recent> info(@Query("access_token") String access_token);

    @GET()
    Call<Authorize> auth(@Url String url);
}
