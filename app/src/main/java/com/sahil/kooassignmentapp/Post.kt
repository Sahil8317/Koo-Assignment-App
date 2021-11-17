package com.sahil.accelerometer

import com.google.gson.annotations.SerializedName

   
data class Post (

   @SerializedName("meta") var meta : Meta,
   @SerializedName("data") var data : List<Data>

)