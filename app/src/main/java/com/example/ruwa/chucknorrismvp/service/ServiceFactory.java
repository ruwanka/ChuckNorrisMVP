package com.example.ruwa.chucknorrismvp.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ruwanka on 4/21/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */
class ServiceFactory{

    private static final String BASE_URL = "http://api.icndb.com/";

    private static final OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();

    private static final Retrofit.Builder retrofitBuilder =
                                        new Retrofit.Builder()
                                        .baseUrl(BASE_URL)
                                        .addConverterFactory(GsonConverterFactory.create());

    public static<S> S create(Class<S> service){
        // build http client, building can be done in several ways e.g. addInterceptor()
        OkHttpClient okHttpClient = okhttpClientBuilder.build();

        /*okhttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        .header("Accept", "application/json")
                        .header("Authorization",
                                token.getTokenType() + " " + token.getAccessToken())
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });*/

        // build retrofit, building can be customized
        Retrofit retrofit = retrofitBuilder.client(okHttpClient).build();

        return retrofit.create(service);
    }

}
