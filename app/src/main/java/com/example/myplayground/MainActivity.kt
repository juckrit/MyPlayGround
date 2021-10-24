package com.example.myplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myplayground.navigation.NavManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var navManager: NavManager = NavManager()
    private val navController get() = (supportFragmentManager.findFragmentById(R.id.navHostFragment) as DynamicNavHostFragment).navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupNav()
        initNavManager()
        setListener()
    }

    private fun setListener() {
        buttonToMainActivity2.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun setupNav() {
        //Initialize the bottom navigation view
        //create bottom navigation view object
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)
        val navController = findNavController(R.id.navHostFragment)
        bottomNavigationView.setupWithNavController(navController)
    }

    private fun initNavManager() {
        navManager.setOnNavEvent { navDirection, extra ->
            extra?.let {
                navController.navigate(navDirection, extra)
            } ?: run {
                navController.navigate(navDirection)
            }
        }
        navManager.setOnNavUp {
            navController.navigateUp()
        }
        navManager.setOnNavUri {
            navController.popBackStack()
            navController.navigate(it)
        }
    }
}