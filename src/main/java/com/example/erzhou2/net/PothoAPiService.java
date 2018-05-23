package com.example.erzhou2.net;



import com.example.erzhou2.bean.PothoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;



public interface PothoAPiService {
    @GET("satinApi?type=3&page=1")
    Observable<PothoBean> getPotho();

}
