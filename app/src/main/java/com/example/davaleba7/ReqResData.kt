package com.example.davaleba7
import com.google.gson.annotations.SerializedName
data class ReqResData<T>(
    @SerializedName("per_page")
    val page:Int?,
    @SerializedName("total_pages")
    val perPage:Int?,
    val total:Int?,
    val totalPage:Int?,
    val data:T?
)
