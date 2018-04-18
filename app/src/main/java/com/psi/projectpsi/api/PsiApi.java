package com.psi.projectpsi.api;


import com.psi.projectpsi.model.PsiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PsiApi {
    @GET("content_share/android_app.php")
    Call <List<PsiModel>> getData(@Query("func") String func);

    @GET("content_share/android_app.php")
    Call <List<PsiModel>> getData(@Query("func") String func, @Query("route_id") Integer id);

}
