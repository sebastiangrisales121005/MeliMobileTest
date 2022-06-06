package com.ceiba.melimobiletest.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.ceiba.domain.usecases.ProductUseCase
import com.ceiba.melimobiletest.R
import com.ceiba.melimobiletest.databinding.ActivityMainBinding
import com.ceiba.melimobiletest.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mActivityMainBinding: ActivityMainBinding
    private val mMainViewModel: MainViewModel? by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mActivityMainBinding.root)

    }

    fun initializeWidgets() {

    }
}
