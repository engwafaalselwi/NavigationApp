package com.example.navigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*


lateinit var drawerLayout : DrawerLayout
lateinit var navigationView : NavigationView
lateinit var actionBarDrawerToggle : ActionBarDrawerToggle

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav)

        val toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        actionBarDrawerToggle = object :ActionBarDrawerToggle(

            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close

        ){
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                setTitle(R.string.app_name)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                setTitle(R.string.app_name)
            }
        }

        actionBarDrawerToggle.isDrawerIndicatorEnabled= true
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
       navigationView.setNavigationItemSelectedListener (this)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun createFragment(fragment: Fragment){
        val currentFragment=supportFragmentManager.findFragmentById(R.id.framConiner)
        if(currentFragment==null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framConiner,fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment:Fragment
        when (item.itemId) {
            R.id.profile -> {
                fragment=HomeFragment.newInstance("Profile",item.itemId)
                createFragment(fragment)
                toolbar.setTitle("Profile")
                Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show()
               return true
            }
            R.id.setting -> {
                // Handle search icon press
                fragment=HomeFragment.newInstance("setting",item.itemId)
                createFragment(fragment)
                toolbar.setTitle("Setting")
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show()
               return true
            }
            R.id.aboutUs -> {
                fragment=HomeFragment.newInstance("aboutUs",item.itemId)
                createFragment(fragment)
                toolbar.setTitle("AboutUs")
                Toast.makeText(this, "aboutUs", Toast.LENGTH_SHORT).show()
               return true
            }
            else ->return false
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true
    }


}

