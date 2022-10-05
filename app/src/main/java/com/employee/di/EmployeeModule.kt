package com.employee.di

import android.app.Application
import androidx.room.Room
import com.employee.data.local.EmployeeDao
import com.employee.data.local.EmployeesDatabase
import com.employee.data.remote.EmployeeApi
import com.employee.data.repository.EmployeeRepositoryImpl
import com.employee.domain.repository.EmployeeRepository
import com.employee.domain.use_case.GetEmployee
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EmployeeModule {

    @Provides
    @Singleton
    fun provideGetEmployeeUseCase(repository: EmployeeRepository): GetEmployee{
        return GetEmployee(repository)
    }

    @Provides
    @Singleton
    fun provideEmployeeRepository(
        db: EmployeesDatabase,
        api: EmployeeApi
    ) : EmployeeRepository{
        return EmployeeRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideEmployeeDatabase(app: Application) : EmployeesDatabase{
        return Room.databaseBuilder(
            app, EmployeesDatabase::class.java, "employee_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideEmployeeApi() : EmployeeApi{
        return Retrofit.Builder()
            .baseUrl(EmployeeApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmployeeApi::class.java)
    }
}