package com.example.course.core.model.body

import com.google.gson.annotations.SerializedName

class Support (
    @SerializedName("url")
    var url : String ,
    @SerializedName("text")
    var text : String
)
