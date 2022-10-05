package com.employee.domain.use_case

import com.employee.core.util.Resource
import com.employee.domain.model.Employee
import com.employee.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow

class GetEmployee(
    private val repository: EmployeeRepository
) {

    operator fun invoke() : Flow<Resource<List<Employee>>>{
        return repository.getEmployee()
    }
}