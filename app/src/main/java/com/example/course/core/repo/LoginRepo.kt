package com.example.course.core.repo

import com.example.course.core.date_sourse.remote.ApiInterface
import com.example.course.core.date_sourse.remote.RetrofitClient
import com.example.course.core.model.body.LoginBodyRequest
import com.example.course.core.model.response.UserResponse
import retrofit2.Response
import retrofit2.Retrofit

class LoginRepo {
    val retrofit = RetrofitClient.getIntance("https://dummyjson.com/")

    suspend fun login(username: String , password: String) : Response<UserResponse>{
       return retrofit.login(LoginBodyRequest(username,password))
    }
}