package br.com.ioasys.camp.educao.service.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.ioasys.camp.educao.service.models.request.RegisterRequest
import br.com.ioasys.camp.educao.service.models.response.RegisterResponse
import br.com.ioasys.camp.educao.service.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RegisterRepository{

    private val request_Response = MutableLiveData<RegisterResponse>()
    val requestResponse: LiveData<RegisterResponse> = request_Response

    internal var onFailureMessage: String? = null

    fun requestRegister(registerRequest: RegisterRequest ): MutableLiveData<RegisterResponse>{
        RetrofitClient.apiService.requestRegister(registerRequest).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                Log.i("Request Response", "onResponse $response")
                response.body().let{
                    request_Response.value = response.body()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.i("No response from API", "onFailure $t")
                onFailureMessage = "$t"
            }
        })

        return request_Response
    }
}