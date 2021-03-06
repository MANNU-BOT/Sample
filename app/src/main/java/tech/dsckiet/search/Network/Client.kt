package tech.dsckiet.search.Network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Client {

    const val BASE_URL = "https://opentdb.com/"


    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val retrofit =
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
            BASE_URL
        ).build()

    val service: Api by lazy {
        retrofit.create(Api::class.java)
    }

}