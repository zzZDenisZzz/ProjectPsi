package com.psi.projectpsi.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.psi.projectpsi.api.PsiApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    static final String BASE_URL = "https://psi.agency";

    public static PsiApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)                                       //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create(gson))  //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();

        PsiApi psiApi = retrofit.create(PsiApi.class);       //Создаем объект, при помощи которого будем выполнять запросы
        return psiApi;

    }
}
