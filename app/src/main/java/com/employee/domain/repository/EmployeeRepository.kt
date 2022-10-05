package com.employee.domain.repository

import com.employee.core.util.Resource
import com.employee.domain.model.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    fun getEmployee(): Flow<Resource<List<Employee>>>
}