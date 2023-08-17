package com.example.course.core.model.response

import com.example.course.core.model.Support
import com.example.course.core.model.User
import com.google.gson.annotations.SerializedName

data class ResponseUserList (
    @SerializedName("page")
var page: Int,

    @SerializedName("per_page")
var perPage:Int,

    @SerializedName("total")
var total:Int,

    @SerializedName("total_pages")
var totalpages: Int,

    @SerializedName("date")
var date: List<User>,

    @SerializedName("support")
var support: Support,

    ){

}