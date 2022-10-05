package com.employee.domain.model

data class EmployeesState(
    val employeeItems: List<Employee> = arrayListOf(),
    val isLoading: Boolean = false
)
