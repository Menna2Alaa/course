package com.example.course

import com.example.course.core.model.body.Post

interface MyCustomClickListener {
    fun onItemClick(post: Post, position: Int)
}