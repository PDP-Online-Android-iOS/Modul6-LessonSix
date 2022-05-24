package dev.ogabek.kotlin.network

import dev.ogabek.kotlin.network.services.EmployeeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {

    const val IS_TESTER = true
    private const val SERVER_DEVELOPMENT = "http://dummy.restapiexample.com/api/v1/"
    private const val SERVER_PRODUCTION = "http://dummy.restapiexample.com/api/v1/"

    private fun server(): String {
        return if (IS_TESTER) {
            SERVER_DEVELOPMENT
        } else {
            SERVER_PRODUCTION
        }
    }

    val retrofit: Retrofit = Retrofit.Builder().baseUrl(server()).addConverterFactory(GsonConverterFactory.create()).build()

    val employeeService = retrofit.create(EmployeeService::class.java)

}