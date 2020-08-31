package com.mcs.applemusicchallenge.injectables

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientSingleton {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://itunes.apple.com/"

    val retrofitInstance: Retrofit?
        get()
        {
            if(retrofit == null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit
        }
}