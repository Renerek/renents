package com.employee.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.employee.data.local.entity.EmployeeEntity

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployees(employees: List<EmployeeEntity>)

    @Query("DELETE FROM employeeEntity")
    suspend fun deleteEmployees()

    @Query("SELECT * FROM employeeEntity")
    suspend fun getEmployees() : List<EmployeeEntity>
}