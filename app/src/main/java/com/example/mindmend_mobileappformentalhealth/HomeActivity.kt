package com.example.mindmend_mobileappformentalhealth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Show TodayFragment only if it's the first time
        if (savedInstanceState == null) {
            loadFragment(TodayFragment())
            bottomNavigationView.selectedItemId = R.id.nav_today // Optional: highlight default
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_today -> TodayFragment()
                R.id.nav_practices -> PracticesFragment()
                R.id.nav_favourite -> FavouriteFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> null
            }

            fragment?.let { loadFragment(it) }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}