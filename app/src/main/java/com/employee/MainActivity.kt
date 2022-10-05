package com.employee

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.coroutineScope
import com.employee.databinding.ActivityMainBinding
import com.employee.presentation.EmployeeAdapter
import com.employee.presentation.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val employeeAdapter = EmployeeAdapter()
    private val viewModel: EmployeeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setData()
    }

    private fun setData() {
        viewModel.onGetEmployee()
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.state.collectLatest {
                if(it.isLoading){

                }else {
                    binding.mRvEmployee.adapter = employeeAdapter
                    employeeAdapter.setContentList(viewModel.state.value.employeeItems)
                }
            }

            viewModel.eventFlow.collectLatest { event ->
                when (event) {
                    is EmployeeViewModel.UIEvent.ShowSnackBar -> {
                        Toast.makeText(applicationContext, event.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}