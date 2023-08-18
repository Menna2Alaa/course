package com.example.course.ui.login

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.course.R

import com.example.course.databinding.ActivityMainBinding
import com.example.course.databinding.CustomDialogBinding
import com.example.course.core.date_sourse.remote.ApiInterface
import com.example.course.core.date_sourse.remote.RetrofitClient
import com.example.course.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPref: SharedPreferences
    lateinit var retrofit: ApiInterface
    lateinit var viewModel :LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= LoginViewModel()

       viewModel.loginDate.observe(this){
         Toast.makeText(this,"Welcome ${it.body()?.firstName}",Toast.LENGTH_SHORT).show()
       }
        binding.register.setOnClickListener {
            viewModel.startlogin(binding.usernameEt.text.toString(),binding.passwordEt.text.toString())
            val intent=Intent(this, ActivitySecondBinding::class.java)
            startActivity(intent)
            finish()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.omenu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.g_t_s_a -> {
                startActivity(Intent(this, ActivitySecondBinding::class.java))
                true
            }

            R.id.exit -> {
                val dialog = Dialog(this)
                val bindingDialog = CustomDialogBinding.inflate(layoutInflater)
                dialog.setContentView(bindingDialog.root)
                bindingDialog.yesB.setOnClickListener {
                    finish()
                }
                bindingDialog.noB.setOnClickListener {
                    dialog.cancel()
                }
                dialog.show()
                true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
