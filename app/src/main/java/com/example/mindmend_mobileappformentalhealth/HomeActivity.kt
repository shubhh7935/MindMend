package com.example.mindmend_mobileappformentalhealth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val nextActivitybtn = findViewById<Button>(R.id.nextActivitybtn)
        nextActivitybtn.setOnClickListener{
            val intent = Intent(this, ExternalStorage::class.java)
            startActivity(intent)
        }
    }
}