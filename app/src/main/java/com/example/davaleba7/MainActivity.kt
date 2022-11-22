package com.example.davaleba7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response
import javax.security.auth.callback.Callback
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val userRecyclerAdapter by lazy { UserRecyclerAdapter(layoutInflater,
        GlideImageLoader(this)
    ) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RestClient.initClient()
        RestClient.reqresApi.getAllUsers(2).enqueue(object:Callback<ReqResData<List<User>>>){
            override fun onResponse(
                call: Call<ReqResData<List<User>>>,
                response: Response<ReqResData<List<User>>>
            ){
                if(response.isSuccessful&&response.body()?.data!=null){
                    response.body()?.data?.let {
                            users ->
                        recyclerView=findViewById(R.id.recycler)
                        recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                        recyclerView.adapter=userRecyclerAdapter
                    }
                    //response.body()?.data?.forEach{user -> Log.d("MY_USER",user.toString()) }
                }
            }
            override fun onFailure(call: Call<ReqResData<List<User>>>, t:Throwable){
                t.message?.toString()?.let { Log.d("USERS","user") }
            }
        }
    }
}