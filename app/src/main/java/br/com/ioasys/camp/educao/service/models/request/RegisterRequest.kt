package br.com.ioasys.camp.educao.service.models.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("course")
    val course: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phonenumber")
    val phonenumber: String
)