package com.josebas.redditclone.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.josebas.redditclone.model.RedditResponse
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://www.reddit.com/"

interface RedditService {
    @GET("top.json")
    fun getTopRedditAsync(): Deferred<RedditResponse>

    companion object {
        operator fun invoke(): RedditService {
            return Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RedditService::class.java)
        }
    }
}