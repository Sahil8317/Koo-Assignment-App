package com.sahil.accelerometer

import com.google.gson.annotations.SerializedName

   
data class Links (

   @SerializedName("previous") var previous : String,
   @SerializedName("current") var current : String,
   @SerializedName("next") var next : String

)