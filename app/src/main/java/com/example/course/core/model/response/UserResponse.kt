package com.example.course.core.model.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("id")
    var id: Int,

    @SerializedName("username")
    var usernamr: Int,

    @SerializedName("email")
    var email: Int,

    @SerializedName("first_name")
    var firstName: Int,

    @SerializedName("last_name")
    var lastName: Int,

    @SerializedName("gender")
    var gender:String,

    @SerializedName("image")
    var image :String,
)
{

}