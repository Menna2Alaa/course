package com.example.course.core.model.body

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("id")
    var id : Int ,
    @SerializedName("title")
    var title : String ,
    @SerializedName("body")
    var body : String ,
    @SerializedName("userId")
    var userId : String ,
    @SerializedName("avatar")
    var avatar : String
)