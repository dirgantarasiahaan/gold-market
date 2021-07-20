package com.mandiri.goldmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    lateinit var mulaiBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        mulaiBtn = findViewById(R.id.mulai_button)
        mulaiBtn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}