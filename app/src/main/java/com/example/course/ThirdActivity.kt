package com.example.course

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.course.databinding.ActivityThirdBinding
import com.example.course.core.date_sourse.remote.RetrofitClient

class ThirdActivity : AppCompatActivity() {
    lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = RetrofitClient.getIntance("https://jsonplaceholder.typicode.com/posts/")
        val comment = intent.extras?.getInt("post_id",0)

       /* binding.postText.text= intent.extras?.getInt("post_id",0).toString()
        binding.idText.text= intent.extras?.getInt("id",0).toString()
        binding.nameText.text= intent.extras?.getInt("name",0).toString()
        binding.emailText.text= intent.extras?.getInt("email",0).toString()
        binding.bodyText.text= intent.extras?.getInt("body",0).toString()*/

    }

}






