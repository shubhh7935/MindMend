package com.example.mindmend_mobileappformentalhealth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private var lastSelectedItemId: Int = R.id.nav_today
    private var backPressedTime: Long = 0
    private lateinit var toast: Toast

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
            if (item.itemId != lastSelectedItemId) {
                lastSelectedItemId = item.itemId
                when (item.itemId) {
                    R.id.nav_today -> loadFragment(TodayFragment())
                    R.id.nav_practices -> loadFragment(PracticesFragment())
                    R.id.nav_favourite -> loadFragment(FavouriteFragment())
                    R.id.nav_profile -> loadFragment(ProfileFragment())
                }
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        //pressing back takes user back to previous tab once.
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            .replace(R.id.nav_host_fragment, fragment)
            .addToBackStack(null) // Adds the transaction to the back stack
            .commit()
    }
    //back navigation works, app closes on double back press.
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                toast.cancel()
                super.onBackPressed()
            } else {
                toast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT)
                toast.show()
            }
            backPressedTime = System.currentTimeMillis()
        }
    }
}