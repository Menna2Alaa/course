package com.example.course

import com.example.course.core.model.Post

interface MyCustomClickListener {
    fun onItemClick(post: Post, position: Int)
}