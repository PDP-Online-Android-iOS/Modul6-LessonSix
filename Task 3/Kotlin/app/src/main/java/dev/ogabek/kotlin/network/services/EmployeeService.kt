package dev.ogabek.kotlin.network.services

import dev.ogabek.kotlin.model.Employee
import dev.ogabek.kotlin.model.RespondListData
import dev.ogabek.kotlin.model.RespondObjectData
import retrofit2.Call
import retrofit2.http.*

interface EmployeeService {

    @GET("employees")
    fun get(): Call<RespondListData<Employee>>

    @GET("employee/{id}")
    fun single(@Path("id") int: Int): Call<RespondObjectData<Employee>>

    @POST("create")
    fun post(@Body employee: Employee): Call<RespondObjectData<Employee>>

    @PUT("update/{id}")
    fun update(@Path("id") int: Int, @Body employee: Employee): Call<RespondObjectData<Employee>>

    @DELETE("delete/{id}")
    fun update(@Path("id") int: Int): Call<RespondObjectData<String>>

}