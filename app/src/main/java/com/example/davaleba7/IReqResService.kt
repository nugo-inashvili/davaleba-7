package com.example.davaleba7
import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface IReqResService {
    @GET("users")
    fun getAllUsers(@Query("page") page:Int): Call<ReqResData<List<User>>>
    Call<List<User>> groupList(@Path("id") val groupId:Int)
    @GET("users/{id}")
    fun getUser(@Path("id") id:Int):Call<ReqResData<User>>
}