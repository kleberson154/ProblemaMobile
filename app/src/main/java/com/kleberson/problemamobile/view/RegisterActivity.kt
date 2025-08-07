package com.kleberson.problemamobile.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kleberson.problemamobile.R

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.editTextNameRegister)
        val email = findViewById<EditText>(R.id.editTextEmailRegister)
        val password = findViewById<EditText>(R.id.editTextPasswordRegister)
        val confirmPassword = findViewById<EditText>(R.id.editTextConfirmRegister)
        val registerButton = findViewById<Button>(R.id.buttonRegister)
        val linkLogin = findViewById<TextView>(R.id.textViewLinkLogin)

        registerButton.setOnClickListener {
            if (name.text.isEmpty() || email.text.isEmpty() || password.text.isEmpty() || confirmPassword.text.isEmpty()) {
                name.error = "Name is required"
                email.error = "Email is required"
                password.error = "Password is required"
                confirmPassword.error = "Confirm Password is required"
            } else if (password.text.toString() != confirmPassword.text.toString()) {
                confirmPassword.error = "Passwords do not match"
            } else {
                startActivity(Intent(this, MainActivity::class.java).apply {
                    putExtra("name", name.text.toString())
                    putExtra("email", email.text.toString())
                })
            }
        }

        linkLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}