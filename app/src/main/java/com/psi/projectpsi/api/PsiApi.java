package com.psi.projectpsi.api;


import com.psi.projectpsi.model.PsiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PsiApi {

    @GET("content_share/android_app.php")
    Call <List<PsiModel>> getData();
}