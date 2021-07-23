package com.mandiri.goldmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignInActivity : AppCompatActivity() {
    lateinit var btnSignUp: Button
    lateinit var btnLogin: Button
    lateinit var viewHide: TextView
    var username: String = "user"
    var password: String = "password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        viewHide = findViewById(R.id.invalid_account)
        viewHide.visibility = View.GONE

        btnSignUp = findViewById(R.id.btn_signup)
        btnSignUp.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener{

            if (username_input.editText?.text.toString().equals(username) &&
                password_input.editText?.text.toString().equals(password)){
                Intent(this, MainActivity::class.java).also { intent ->
                    intent.putExtra(TAG_NAME, username_input.editText?.text.toString())
                    startActivity(intent)
                }
            } else {
                viewHide.visibility = View.VISIBLE
            }

        }

    }

    companion object {
        const val TAG_NAME = "USERNAME"
    }
}