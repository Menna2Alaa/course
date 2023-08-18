package com.example.course.core.repo

import com.example.course.core.date_sourse.remote.RetrofitClient
import com.example.course.core.model.body.Post
import retrofit2.Response

class PostsRepo {
    val retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")
    suspend fun getPosts(userId : Int) : Response<ArrayList<Post>> {
        return retrofit.getPostByUser(userId)
    }
}
