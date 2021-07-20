package com.mandiri.goldmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val usernameFromSiginActivity= intent.getStringExtra(SignInActivity.TAG_NAME)
        val usernameFromSigupActivity= intent.getStringExtra(SignInActivity.TAG_NAME)

        if (usernameFromSiginActivity != null){
            welcomeMessage(usernameFromSiginActivity)
        } else if (usernameFromSigupActivity != null) {
            welcomeMessage(usernameFromSigupActivity)
        }

    }

    fun welcomeMessage(username: String) {
        textView.text = "$username Welcome to Home activity"
    }


}