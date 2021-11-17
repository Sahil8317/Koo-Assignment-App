package com.sahil.kooassignmentapp

import com.sahil.accelerometer.Post
import retrofit2.Call
import retrofit2.http.GET

interface RestApi {

    @get:GET("posts")
    var postList: Call<Post>


}