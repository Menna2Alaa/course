package com.example.course.ui.second_activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.course.core.model.body.Comment
import com.example.course.core.model.body.Post
import com.example.course.core.repo.CommentsRepo
import com.example.course.core.repo.PostsRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel: ViewModel() {
    var postsInformations: MutableLiveData<Response<ArrayList<Post>>> = MutableLiveData()
    private val repo = PostsRepo()

    var commentsInformations: MutableLiveData<Response<ArrayList<Comment>>> = MutableLiveData()
    val repo1 = CommentsRepo()

    fun posts(userId: Int) {
        viewModelScope.launch {
            postsInformations.postValue(repo.getPosts(userId))
        }
    }

    fun comments(postId: Int) {
        viewModelScope.launch {
            commentsInformations.postValue(repo1.getComments(postId))
        }
    }
}
