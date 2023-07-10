package com.evirgenoguz.cocktailapp.ui

import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.evirgenoguz.cocktailapp.core.BaseActivity
import com.evirgenoguz.cocktailapp.databinding.ActivityMainBinding
import com.evirgenoguz.cocktailapp.ext.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    private lateinit var navController: NavController


    override fun setupUI() {
        // getting NavController with findNavController
        // extension.
        navController = findNavController()

        binding.bottomNavMenu.setupWithNavController(navController)

    }


}