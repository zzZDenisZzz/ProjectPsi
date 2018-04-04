package com.psi.projectpsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.psi.projectpsi.api.PsiApi;
import com.psi.projectpsi.controller.Controller;
import com.psi.projectpsi.model.PsiModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static PsiApi psiApi;
    RecyclerView recyclerView;
    List<PsiModel> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        psiApi = Controller.getApi();

        posts = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        PsiAdapter adapter = new PsiAdapter(posts);
        recyclerView.setAdapter(adapter);


        psiApi.getData("getServicesList").enqueue(new Callback<List<PsiModel>>() {
            @Override
            public void onResponse(Call<List<PsiModel>> call, Response<List<PsiModel>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PsiModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
