package br.com.ioasys.camp.educao.service.models.response


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("birthdate")
    val birthdate: String,
    @SerializedName("course")
    val course: String,
    @SerializedName("current token")
    val currentToken: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("token")
    val token: String
)