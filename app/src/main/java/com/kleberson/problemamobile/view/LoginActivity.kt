package com.kleberson.problemamobile.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kleberson.problemamobile.R

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.editTextInputEmail)
        val password = findViewById<EditText>(R.id.editTextInputPassword)
        val loginButton = findViewById<Button>(R.id.buttonEnter)
        val linkRegister = findViewById<TextView>(R.id.textViewLinkRegister)

        loginButton.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            if (emailText.isEmpty() || passwordText.isEmpty()) {
                email.error = "Email cannot be empty"
                password.error = "Password cannot be empty"
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        linkRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }
}