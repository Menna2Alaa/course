package com.example.course.core.repo

import com.example.course.core.date_sourse.remote.RetrofitClient
import com.example.course.core.model.body.Comment
import retrofit2.Response

class CommentsRepo {
    val retrofit = RetrofitClient.getInstance("https://jsonplaceholder.typicode.com/")
    suspend fun getComments(postId : Int) : Response<ArrayList<Comment>> {
        return retrofit.getComments(postId)
    }
}
