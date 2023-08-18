package com.example.course.core.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.course.databinding.PostItemBinding

data class PostItem(var userName : String, var time : String, var post : String, var imageurl : String): AppCompatActivity() {
    private lateinit var binding: PostItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PostItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
