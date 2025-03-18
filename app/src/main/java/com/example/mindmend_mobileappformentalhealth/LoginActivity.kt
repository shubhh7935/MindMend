package com.example.mindmend_mobileappformentalhealth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var facebookLogin: ImageView
    private lateinit var googleLogin: ImageView
    private lateinit var twitterLogin: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        facebookLogin = findViewById(R.id.facebookLogin)
        googleLogin = findViewById(R.id.googleLogin)
        twitterLogin = findViewById(R.id.twitterLogin)

        // Handle login button click
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Example authentication check
                if (email == "test@gmail.com" && password == "password") {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SurveyActivity::class.java)
                    startActivity(intent)
                    finish() // Close LoginActivity after successful login
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }


        // Handle social media login clicks
        facebookLogin.setOnClickListener {
            Toast.makeText(this, "Facebook login clicked", Toast.LENGTH_SHORT).show()
        }

        googleLogin.setOnClickListener {
            Toast.makeText(this, "Google login clicked", Toast.LENGTH_SHORT).show()
        }

        twitterLogin.setOnClickListener {
            Toast.makeText(this, "Twitter login clicked", Toast.LENGTH_SHORT).show()
        }
    }
}