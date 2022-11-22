package com.example.davaleba7
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    private lateinit var retrofit: Retrofit
    private lateinit var okHttp: OkHttpClient
    val reqresApi:IReqResService
        get() = getService(IReqResService::class.java)
    fun initClient(){
        okHttp=OkHttpClient.Builder().build()
        retrofit=Retrofit.Builder().baseUrl("https://reqres.in/api/")
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun<T> getService(service:Class<T>):T{
        return retrofit.create(service)
    }
}