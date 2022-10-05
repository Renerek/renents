package com.employee.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.employee.data.local.entity.EmployeeEntity

@Database(
    entities = [EmployeeEntity::class],
    version = 1
)
abstract class EmployeesDatabase : RoomDatabase() {

    abstract val dao: EmployeeDao
}