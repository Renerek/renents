package com.employee.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.employee.domain.model.Employee

@Entity
data class EmployeeEntity(
    val biography: String?,
    val emailAddress: String?,
    val employeeType: String?,
    val fullName: String?,
    val phoneNumber: String?,
    val photoUrlLarge: String?,
    val photoUrlSmall: String?,
    val team: String?,
    @PrimaryKey val uuid: String
){
    fun toEmployee() : Employee{
        return Employee(
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
