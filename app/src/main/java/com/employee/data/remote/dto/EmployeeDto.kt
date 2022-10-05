package com.employee.data.remote.dto

import com.employee.data.local.entity.EmployeeEntity
import com.google.gson.annotations.SerializedName

data class EmployeeDto(
    @SerializedName("biography")
    val biography: String?,
    @SerializedName("email_address")
    val emailAddress: String?,
    @SerializedName("employee_type")
    val employeeType: String?,
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?,
    @SerializedName("photo_url_large")
    val photoUrlLarge: String?,
    @SerializedName("photo_url_small")
    val photoUrlSmall: String?,
    @SerializedName("team")
    val team: String?,
    @SerializedName("uuid")
    val uuid: String
){
    fun toEmployeeEntity() : EmployeeEntity{
        return EmployeeEntity(
            biography = biography,
            emailAddress = emailAddress,
            employeeType = employeeType,
            fullName = fullName,
            phoneNumber = phoneNumber,
            photoUrlLarge = photoUrlLarge,
            photoUrlSmall = photoUrlSmall,
            team = team,
            uuid = uuid
        )
    }
}