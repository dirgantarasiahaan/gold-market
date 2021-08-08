package com.mandiri.goldmarket

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.mandiri.goldmarket.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.findNavController()

        binding.apply {
            hideBottomNav()
            bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.homeFragmentMenu -> {
                        showBottomNav()
                        navController.navigate(
                            R.id.homeFragment, null,
                            NavOptions.Builder().setPopUpTo(R.id.nav_graph, true).build()); true
                    }
                    R.id.historyFragmentMenu -> {
                        showBottomNav()
                        navController.navigate(
                            R.id.historyFragment, null,
                            NavOptions.Builder().setPopUpTo(R.id.nav_graph, true).build());true
                    }
                    R.id.profileFragmentMenu -> {
                        showBottomNav()
                        navController.navigate(
                            R.id.profileFragment, null,
                            NavOptions.Builder().setPopUpTo(R.id.nav_graph, true).build());true
                    }
                    else -> {
                        hideBottomNav()
                        false
                    }
                }
            }
        }

//        binding.bottomNavigationView.setupWithNavController(navController)
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

    fun hideBottomNav(){
        binding.bottomNavigationView.visibility = View.GONE
    }
    fun showBottomNav(){
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
}