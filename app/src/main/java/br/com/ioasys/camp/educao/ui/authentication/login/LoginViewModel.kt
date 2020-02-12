package br.com.ioasys.camp.educao.ui.authentication.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ioasys.camp.educao.service.models.request.LoginRequest
import br.com.ioasys.camp.educao.service.models.response.LoginResponse
import br.com.ioasys.camp.educao.service.repository.LoginRepository

class LoginViewModel : ViewModel() {

    private var loginRepository: LoginRepository = LoginRepository

    internal var loginObservable = MutableLiveData<LoginResponse>()


//    private lateinit var errorMessage: String


    fun requestLogin(loginRequest: LoginRequest){
        loginObservable = loginRepository.loginUser(loginRequest)
    }

//    fun requestLoginObserver(): LiveData<LoginResponse>{
//        return
//    }

//    fun loginError(){
//        errorMessage = loginRepository.server_Response
//    }
}

