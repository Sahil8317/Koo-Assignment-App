package com.sahil.kooassignmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sahil.accelerometer.Data
import com.sahil.accelerometer.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// using retrofit for API GET calls and RecyclerView Component for User Interface
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val restApi = postService()
        var dataList:List<Data>
        val call: Call<Post> = restApi.postList
        call.enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                if(response.isSuccessful){
                    dataList = response.body()!!.data
                    val recyclerView:RecyclerView = findViewById(R.id.recycler_view)
                    recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    recyclerView.setHasFixedSize(true)
                    val postAdaptor = PostAdaptor()
                    recyclerView.adapter = postAdaptor
                    postAdaptor.setPostArray(dataList)
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                println("Error")
                println(t.message)
            }
        })
    }

    private fun postService(): RestApi {
        val baseURL = "https://gorest.co.in/public/v1/"
        val retrofit = Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(RestApi::class.java)
    }

}

