package com.mandiri.goldmarket

import android.app.ActionBar
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.mandiri.goldmarket.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var usernameFromSiginActivity : String
    lateinit var usernameFromSigupActivity : String
    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usernameFromSiginActivity = intent.getStringExtra(SignInActivity.TAG_NAME).toString()
        usernameFromSigupActivity = intent.getStringExtra(SignInActivity.TAG_NAME).toString()

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.findNavController()
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    fun findUsername(signInUsername: String, signUpUsername: String): String{
        var user: String = ""
        if (signInUsername != null){
            user = signInUsername
        } else if (signUpUsername != null) {
            user = signUpUsername
        }
        Log.d("username", user)
        return user
    }
}