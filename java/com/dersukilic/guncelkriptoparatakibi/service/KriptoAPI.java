package com.dersukilic.guncelkriptoparatakibi.service;

import com.dersukilic.guncelkriptoparatakibi.model.KriptoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KriptoAPI {

    //https://api.nomics.com/v1/prices?key=46d2e924a1e978d5b51dc055e16b6eb3f0d5b833

    @GET("prices?key=46d2e924a1e978d5b51dc055e16b6eb3f0d5b833")
    Call<List<KriptoModel>> getData();

}
