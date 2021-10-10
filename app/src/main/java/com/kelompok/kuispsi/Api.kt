package com.kelompok.kuispsi

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("api/films")
    fun getContent(): Call<ArrayList<ContentResponse>>
}