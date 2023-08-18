package com.example.course.ui.second_activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.course.CommentAdapter
import com.example.course.CustomAdapter
import com.example.course.MyCustomClickListener
import com.example.course.R
import com.example.course.ui.third_activity.ThirdActivity
import com.example.course.databinding.ActivitySecondBinding
import com.example.course.core.model.body.Post
import com.example.course.core.date_sourse.remote.ApiInterface
import com.example.course.ui.login.MainActivity


class SecondActivity: AppCompatActivity(), MyCustomClickListener {
    lateinit var binding: ActivitySecondBinding
    lateinit var postAdapter: CustomAdapter
    lateinit var commentAdapter : CommentAdapter
    lateinit var sharedPref: SharedPreferences
    lateinit var retrofit: ApiInterface
    lateinit var viewModel : SecondViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = applicationContext.getSharedPreferences("UserPref", Context.MODE_PRIVATE)

        viewModel = SecondViewModel()
        viewModel.postsInformations.observe(this){
            if (it.isSuccessful) {
                val posts = it.body()
                if (posts != null) {
                    postAdapter = CustomAdapter(posts, this@SecondActivity)
                    binding.post.layoutManager = LinearLayoutManager(this@SecondActivity)
                    binding.post.adapter = postAdapter
                } else {
                    Toast.makeText(this@SecondActivity, "No posts found", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this@SecondActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }
        binding.getPostButton.setOnClickListener {
            viewModel.posts(binding.getPostTv.text.toString().toInt())
        }
        viewModel.commentsInformations.observe(this){
            if(it.isSuccessful){
                val comments = it.body()
                if(comments!=null){
                    commentAdapter = CommentAdapter(comments)
                    binding.post.layoutManager = LinearLayoutManager(this@SecondActivity)
                    binding.post.adapter = commentAdapter
                }else {
                    Toast.makeText(this@SecondActivity, "No comments found", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this@SecondActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }

//        binding.getPostButton.setOnClickListener {
//            lifecycleScope.launchWhenCreated {
//                val response = retrofit.getPostByUser(binding.getPostTv.text.toString().toInt())
//                if (response.isSuccessful) {
//                    postAdapter = CustomAdapter(response.body() ?: listOf(), this@SecondActivity)
//                    binding.post.layoutManager = LinearLayoutManager(this@SecondActivity)
//                    binding.post.adapter = postAdapter
//                } else {
//                    Toast.makeText(this@SecondActivity, "error", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }

    override fun onItemClick(post: Post, position: Int) {
        viewModel.comments(binding.getPostTv.text.toString().toInt())
        val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
        intent.putExtra("post_id", post.id)
        startActivity(intent)

//        lifecycleScope.launchWhenCreated {
//            val response = retrofit.getComments(post.id)
//            if (response.isSuccessful) {
//                val comment = response.body()?.get(0)
//                var intent = Intent(this@SecondActivity, ThirdActivity::class.java)
//                intent.putExtra("post_id", comment?.postId)
//                intent.putExtra("id", comment?.id)
//                intent.putExtra("email", comment?.email)
//                intent.putExtra("name", comment?.name)
//                intent.putExtra("body", comment?.body)
//                startActivity(intent)
//            } else {
//                Toast.makeText(this@SecondActivity, "error", Toast.LENGTH_SHORT).show()
//            }
//        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_second_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.loginout -> {

                val editor = sharedPref.edit()
                editor.remove("USERNAME")
                editor.putBoolean("IS_LOGIN", false)
                editor.remove("PASSWORD")
                editor.commit()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}


    /*fun onItemClick(post: User, position: Int) {
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra("username", post.username)
        intent.putExtra("date", post.date)
        intent.putExtra("post", post.post)
        startActivity(intent)
    }
*/
