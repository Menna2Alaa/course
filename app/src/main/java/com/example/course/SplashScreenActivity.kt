package com.example.course

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import com.example.course.databinding.ActivitySplashBinding
import com.example.course.ui.login.MainActivity
import com.example.course.ui.second_activity.SecondActivity

class SplashScreenActivity :  ComponentActivity() {
    lateinit var binding :ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)
        val sharedPref = applicationContext.getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        val islogged = sharedPref.getBoolean("IS_LOGIN",false)
        Handler().postDelayed(Runnable {
            if (islogged) {
                startActivity(Intent(this, SecondActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
            finish()
        }, 3000)



    }
}