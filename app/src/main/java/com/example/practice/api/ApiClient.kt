package com.example.practice.api

import android.content.Context
import com.example.practice.interceptor.AuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var retrofit: Retrofit? = null

    fun getApi(context: Context): MelogApi {
        if (retrofit == null) {
            val client = OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor(context))
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl("https://melog.ngrok.app") // 실제 API URL로 변경
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!.create(MelogApi::class.java)
    }
}
