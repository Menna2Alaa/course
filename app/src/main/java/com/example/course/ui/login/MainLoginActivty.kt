package com.example.course.ui.login

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.course.R
import com.example.course.SecondActivity
import com.example.course.databinding.ActivityMainBinding
import com.example.course.databinding.CustomDialogBinding
import com.example.course.core.date_sourse.remote.ApiInterface
import com.example.course.core.date_sourse.remote.RetrofitClient

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPref: SharedPreferences
    lateinit var retrofit: ApiInterface
    lateinit var ViewModel :LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       retrofit = RetrofitClient.getIntance("https://dummyjson.com/")

       ViewModel.loginDate.observe(this){
         Toast.makeText(this,"Welcome ${it.body()?.firstName}",Toast.LENGTH_SHORT).show()
       }
            binding.register.setOnClickListener {
            ViewModel.startlogin(binding.usernameEt.text.toString(),binding.passwordEt.text.toString())

            /*lifecycleScope.launchWhenCreated {
                val response = retrofit.login(
                LoginBodyRequest(binding.usernameEt.text.toString(),binding.passwordEt.text.toString()))
                if (response.isSuccessful) {
                    moveToNextScreen()
                }

                else{
                    val json =JSONObject(response.errorBody()?.string())
                    Toast.makeText(this@MainActivity,json.getString("massage"),Toast.LENGTH_LONG).show()
                }
            }*/


        }



    }
    fun moveToNextScreen(){
        val editor = sharedPref.edit()
        editor.putString("user ${binding.usernameEt.text.toString()}",binding.usernameEt.text.toString())
        editor.putString("password ${binding.usernameEt.text.toString()}",binding.passwordEt.text.toString())
        editor.putBoolean("IS_LOGIN", true)
        editor.commit()

        val intent = Intent(this, SecondActivity::class.java)


        startActivity(intent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.omenu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.g_t_s_a -> {
                startActivity(Intent(this, SecondActivity::class.java))
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
