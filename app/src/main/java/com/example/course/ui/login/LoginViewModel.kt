package com.example.course.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.course.core.model.response.UserResponse
import com.example.course.core.repo.LoginRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel : ViewModel() {
    var loginDate :MutableLiveData<Response<UserResponse>> =MutableLiveData()
    val repo =LoginRepo()
    fun startlogin (username:String,password:String){
        viewModelScope.launch{
            loginDate.postValue( repo.login(username,password))

        }


    }

}
