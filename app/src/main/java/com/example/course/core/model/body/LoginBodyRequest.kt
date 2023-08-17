package com.example.course.core.model.body

import com.google.gson.annotations.SerializedName

data class LoginBodyRequest (
    @SerializedName("username")
    val username : String,
    @SerializedName("password")
    val passwoed : String
){

}