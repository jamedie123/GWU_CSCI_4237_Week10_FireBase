package com.example.loginappinclass

import com.google.android.gms.common.api.internal.ApiKey
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor

class YelpManager {
    val okHttpClient: OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level  = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(loggingInterceptor)
        okHttpClient = builder.build()
    }
    fun retrieveYelps(lat:Double, long: Double, apiKey: String): List<YelpBusiness> {

        val request= Request.Builder()
            .url("https://api.yelp.com/v3/businesses/search?longitude=-$long&latitude=$lat")
            .header(
                "Authorization",
                "Bearer $apiKey"
            )
            .get()
            .build()

        val response = okHttpClient.newCall(request).execute()
        val responseBody: String ?=response.body?.string()

        return listOf()
    }
}