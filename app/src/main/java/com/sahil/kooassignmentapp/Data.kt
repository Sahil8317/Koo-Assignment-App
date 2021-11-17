package com.sahil.accelerometer

import com.google.gson.annotations.SerializedName

   
data class Data (

   @SerializedName("id") var id : Int,
   @SerializedName("user_id") var userId : Int,
   @SerializedName("title") var title : String,
   @SerializedName("body") var body : String

)