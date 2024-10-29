package com.tasty.recipesapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onStart() {
        super.onStart()
        Log.i("SplashActivity", "onStart")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("SplashActivity", "onCreate")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }

    override fun onResume() {
        super.onResume()
        Log.i("SplashActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("SplashActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("SplashActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("SplashActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("SplashActivity", "onRestart")
    }

}