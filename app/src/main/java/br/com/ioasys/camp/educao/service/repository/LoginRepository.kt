package br.com.ioasys.camp.educao.service.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.ioasys.camp.educao.service.models.request.LoginRequest
import br.com.ioasys.camp.educao.service.models.response.LoginResponse
import br.com.ioasys.camp.educao.service.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LoginRepository {

    private val login_Response = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = login_Response

    lateinit var server_Response: String
    //val serverResponse: LiveData<String> = server_Response
    
    
    fun loginUser(loginRequest: LoginRequest): MutableLiveData<LoginResponse>{
        RetrofitClient.apiService
            .requestLogin(loginRequest)
            .enqueue(object : Callback<LoginResponse>{
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    Log.i("pedido rolou", "onResponse $response")
                    response.body()?.let{
                        login_Response.value = response.body()

                    }


                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.i("Login failed", "onFailure $t")

//                    when("$t") {
//                        "Invalid password"  -> server_Response = "Senha incorreta"
//                        "User not Found" -> server_Response = "Usuário não encontrado"
//                        "The user could not be authenticated" -> server_Response
//                    }
                }
            }
        )

        

        return login_Response
    }
}