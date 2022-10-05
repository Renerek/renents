package com.employee.domain.model

import com.employee.data.remote.dto.EmployeeDto

data class EmployeeResponse(
    val employees: List<EmployeeDto>
)