package za.co.gundula.app.arereyeng.rest;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kgundula on 2016/12/24.
 */

public class RetrofitInterceptor implements Interceptor {


    String token = "";
    String bearer = "";

    public RetrofitInterceptor(String token, String bearer) {
        this.token = token;
        this.bearer = bearer;
    }

    public RetrofitInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Log.i("Ygritte", "Authorization" + bearer + " " + token);
        // Authorization: Bearer eyJ0eXAiOiJ32aQiLCJhbGciOiJSUzI1NiIsIfg1iCI6ImEzck1VZ01Gd8d0UGNsTGE2eUYz...
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Accept", "application/json");
        builder.addHeader("Content-Type", "application/json");
        builder.addHeader("Authorization", bearer + " " + token);
        return chain.proceed(builder.build());
    }
}
