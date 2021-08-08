package com.riyas.playstorehomepage.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.riyas.playstorehomepage.R

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView:BottomNavigationView
    lateinit var mike : ImageView
    lateinit var profile : ImageView
    lateinit var hamburger : ImageView

    val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.games -> {
                val fragment = GamesFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.apps -> {
                val fragment = AppsFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.movie -> {
                val fragment = MoviesFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.books -> {
                val fragment = BooksFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        mike = findViewById(R.id.mike)
        profile = findViewById(R.id.user)
        hamburger = findViewById(R.id.ham)
        mike.setOnClickListener{
            Toast.makeText(this, "Mike Icon Clicked!!", Toast.LENGTH_SHORT).show()
        }
        profile.setOnClickListener{
            Toast.makeText(this, "Profile Icon Clicked!!", Toast.LENGTH_SHORT).show()
        }
        hamburger.setOnClickListener{
            Toast.makeText(this, "Hamburger Icon Clicked!!", Toast.LENGTH_SHORT).show()
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = GamesFragment()
        addFragment(fragment)
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .commit()
    }
}