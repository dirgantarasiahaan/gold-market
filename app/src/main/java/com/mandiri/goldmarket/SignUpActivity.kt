package com.mandiri.goldmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    lateinit var btnSignIn: Button
    lateinit var registerBtn: Button
    lateinit var viewHide: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        viewHide = findViewById(R.id.failed_register)
        viewHide.visibility = View.GONE

        btnSignIn = findViewById(R.id.btn_signin)
        btnSignIn.setOnClickListener{
            finish()
        }



        registerBtn = findViewById(R.id.btn_register)
        registerBtn.setOnClickListener{
            if (username_text.editText?.text.toString().isNotBlank() &&
                    password_text.editText?.text.toString().isNotBlank() &&
                    firstname_text.editText?.text.toString().isNotBlank() &&
                    lastname_text.editText?.text.toString().isNotBlank()){
                Intent(this, HomeActivity::class.java).also { intent ->
                    intent.putExtra(SignUpActivity.TAG_NAME, username_text.editText?.text.toString())
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