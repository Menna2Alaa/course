package com.example.course.core.model

import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("id")
    var id: String,

    @SerializedName("postId")
    var postId:String,

    @SerializedName("name")
    var name:String,

    @SerializedName("email")
    var email: String,

    @SerializedName("body")
    var body: String,


) {
}