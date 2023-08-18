package com.example.course.ui.third_activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.course.CommentAdapter
import com.example.course.databinding.ActivityThirdBinding
import com.example.course.core.date_sourse.remote.RetrofitClient
import com.example.course.ui.second_activity.SecondViewModel

class ThirdActivity : AppCompatActivity() {
    lateinit var binding: ActivityThirdBinding
    lateinit var viewModel: SecondViewModel
    lateinit var commentAdapter : CommentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val comment = intent.extras?.getInt("post_id",0)
        viewModel = SecondViewModel()
        viewModel.comments(comment.toString().toInt())
        viewModel.commentsInformations.observe(this) {
            if (it.isSuccessful) {
                commentAdapter = CommentAdapter(it.body()?: listOf())
                binding.comment.layoutManager= LinearLayoutManager(this@ThirdActivity)
                binding.comment.adapter = commentAdapter
            } else {
                Toast.makeText(this@ThirdActivity, "error", Toast.LENGTH_LONG).show()
            }
        }


       /* binding.postText.text= intent.extras?.getInt("post_id",0).toString()
        binding.idText.text= intent.extras?.getInt("id",0).toString()
        binding.nameText.text= intent.extras?.getInt("name",0).toString()
        binding.emailText.text= intent.extras?.getInt("email",0).toString()
        binding.bodyText.text= intent.extras?.getInt("body",0).toString()*/

    }

}






