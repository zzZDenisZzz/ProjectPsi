package com.psi.projectpsi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.psi.projectpsi.api.PsiApi;
import com.psi.projectpsi.controller.Controller;
import com.psi.projectpsi.model.PsiModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceActivity extends AppCompatActivity {

    PsiApi psiApi;
    TextView textService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);

        psiApi = Controller.getApi();

        textService = findViewById(R.id.text_service);

        psiApi.getData("getServiceContent",343).enqueue(new Callback<List<PsiModel>>() {
            @Override
            public void onResponse(Call<List<PsiModel>> call, Response<List<PsiModel>> response) {
               // response.body();
            }

            @Override
            public void onFailure(Call<List<PsiModel>> call, Throwable t) {
                Toast.makeText(ServiceActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
