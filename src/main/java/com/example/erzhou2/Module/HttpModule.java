package com.example.erzhou2.Module;



import com.example.erzhou2.net.Api;
import com.example.erzhou2.net.PothoAPi;
import com.example.erzhou2.net.PothoAPiService;
import com.example.erzhou2.net.VideoAPi;
import com.example.erzhou2.net.VideoAPiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    PothoAPi providePothoAPi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        PothoAPiService pothoAPiService = retrofit.create(PothoAPiService.class);
        return PothoAPi.getPothoAPi(pothoAPiService);
    }
    @Provides
    VideoAPi provideVideoAPi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        VideoAPiService videoAPiService = retrofit.create(VideoAPiService.class);
        return VideoAPi.getVideoAPi(videoAPiService);
    }
}
