package com.ppereira.networking.provider

import com.ppereira.networking.data.RepoApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

class ApiProvider {

    val githubApi: RepoApi by lazy { retrofit.create(RepoApi::class.java) }

    private val moshi: Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val okHttp: OkHttpClient by lazy {
        val logging = HttpLoggingInterceptor { Timber.tag("OkHttp").i(it) }
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder().addInterceptor(logging).build()
    }

    private val retrofit: Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttp)
            .baseUrl("https://api.github.com/")
            .build()
}
