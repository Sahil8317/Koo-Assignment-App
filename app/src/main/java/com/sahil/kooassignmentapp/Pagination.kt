package com.sahil.accelerometer

import com.google.gson.annotations.SerializedName

   
data class Pagination (

   @SerializedName("total") var total : Int,
   @SerializedName("pages") var pages : Int,
   @SerializedName("page") var page : Int,
   @SerializedName("limit") var limit : Int,
   @SerializedName("links") var links : Links

)