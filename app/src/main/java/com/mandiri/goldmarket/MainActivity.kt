package com.mandiri.goldmarket

import android.app.ActionBar
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var historyFragment: HistoryFragment
    lateinit var profileFragment : ProfileFragment
    lateinit var usernameFromSiginActivity : String
    lateinit var usernameFromSigupActivity : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameFromSiginActivity = intent.getStringExtra(SignInActivity.TAG_NAME).toString()
        usernameFromSigupActivity = intent.getStringExtra(SignInActivity.TAG_NAME).toString()

        homeFragment = HomeFragment()
        historyFragment = HistoryFragment()
        profileFragment = ProfileFragment()

        btnHome.setOnClickListener{
            switchFragment(homeFragment)
        }
        btnHistory.setOnClickListener{
            switchFragment(historyFragment)
        }
        btnProfil.setOnClickListener{
            switchFragment(profileFragment)
        }



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

    fun welcomeMessage(username: String) {
//        greeting.text = "$username Welcome to Home activity"
    }

    fun switchFragment(fragmentInput: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        when(fragmentInput){
            is HomeFragment -> {
                transaction.replace(R.id.fragment_container,fragmentInput)
                transaction.commit()
            }

            is HistoryFragment -> {
                transaction.replace(R.id.fragment_container, fragmentInput)
                transaction.commit()
            }

            is ProfileFragment -> {
                transaction.replace(R.id.fragment_container, fragmentInput)
                transaction.commit()
            }

        }
    }
}