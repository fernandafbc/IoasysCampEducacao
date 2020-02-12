package br.com.ioasys.camp.educao.service.models.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: User,
    var currentToken: String?
)

data class User(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("student")
    val student: Student,
    @SerializedName("__v")
    val v: Int
)


data class Student(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("birthdate")
    val birthdate: String,
    @SerializedName("course")
    val course: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("__v")
    val v: Int
)