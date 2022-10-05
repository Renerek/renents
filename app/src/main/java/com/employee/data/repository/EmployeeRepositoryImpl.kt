package com.employee.data.repository

import com.employee.core.util.Resource
import com.employee.data.local.EmployeeDao
import com.employee.data.remote.EmployeeApi
import com.employee.domain.model.Employee
import com.employee.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class EmployeeRepositoryImpl(
    private val api: EmployeeApi,
    private val dao: EmployeeDao
) : EmployeeRepository{
    override fun getEmployee(): Flow<Resource<List<Employee>>> = flow{
        emit(Resource.Loading())

        val employees = dao.getEmployees().map { it.toEmployee() }
        emit(Resource.Loading(data = employees))

        try {
            val remoteEmployees = api.getEmployees()
            dao.deleteEmployees()
            dao.insertEmployees(remoteEmployees.employees.map { it.toEmployeeEntity() })
        } catch (e: HttpException){
            emit(Resource.Error(
                message = "Oops, Something went wrong!",
                data = employees
            ))
        } catch (e: IOException){
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = employees
            ))
        }

        val newEmployees = dao.getEmployees().map { it.toEmployee() }
        emit(Resource.Success(newEmployees))
    }
}