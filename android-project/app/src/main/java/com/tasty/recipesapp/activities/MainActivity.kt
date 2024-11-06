package com.tasty.recipesapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.fragment.app.replace
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.ActivityMainBinding
import com.tasty.recipesapp.ui.home.HomeFragment
import com.tasty.recipesapp.ui.profile.ProfileFragment
import com.tasty.recipesapp.ui.recipe.RecipesFragment
import com.tasty.recipesapp.viewmodel.RecipeListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> replaceFragment(HomeFragment())
                R.id.recipesFragment -> replaceFragment(RecipesFragment())
                R.id.profileFragment -> replaceFragment(ProfileFragment())

                else -> {

                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}