package com.dersukilic.guncelkriptoparatakibi.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dersukilic.guncelkriptoparatakibi.R;
import com.dersukilic.guncelkriptoparatakibi.adapter.RecViewA;
import com.dersukilic.guncelkriptoparatakibi.model.KriptoModel;
import com.dersukilic.guncelkriptoparatakibi.service.KriptoAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.design_menu_item_home:
                Toast.makeText(getApplicationContext(), "Hazirlayan:Silan Dersu Kilic, Mail:silandersu25@gmail.com", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }


    ArrayList<KriptoModel> kriptoModels;
    private String BASE_URL = "https://api.nomics.com/v1/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecViewA recViewA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //https://api.nomics.com/v1/prices?key=46d2e924a1e978d5b51dc055e16b6eb3f0d5b833

        recyclerView = findViewById(R.id.recyclerView);


        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        loadData();
    }

    private void loadData() {

        KriptoAPI kriptoAPI = retrofit.create(KriptoAPI.class);
        Call<List<KriptoModel>> call = kriptoAPI.getData();

        call.enqueue(new Callback<List<KriptoModel>>() {
            @Override
            public void onResponse(Call<List<KriptoModel>> call, Response<List<KriptoModel>> response) {

                if (response.isSuccessful()) {
                    List<KriptoModel> responseList = response.body();
                    kriptoModels = new ArrayList<>(responseList);


                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recViewA = new RecViewA(kriptoModels);
                    recyclerView.setAdapter(recViewA);


                    /*for (KriptoModel kriptoModel : kriptoModels){
                        System.out.println(kriptoModel.currency);
                        System.out.println(kriptoModel.price);
                    }

                     */
                }
            }

            @Override
            public void onFailure(Call<List<KriptoModel>> call, Throwable t) {

                System.out.println(kriptoModels);

            }
        });



    }

}
























