package com.employee.data.remote

import com.employee.domain.model.EmployeeResponse
import retrofit2.http.GET

interface EmployeeApi {

    @GET("employees.json")
    suspend fun getEmployees() : EmployeeResponse

    companion object{
        const val BASE_URL = "https://s3.amazonaws.com/sq-mobile-interview/"
    }
}