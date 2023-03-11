package com.example.dailynewsadda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigationView.setNavigationItemSelectedListener(this)
        setToolBarTitle("Dashboard")
        changeFragment(HomeFragment())


        //Navigation icon color change code
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.itemIconTintList = null

        //Set Tittle
        title = getString(R.string.app_name)

        //find drawer layout
        drawerLayout = findViewById(R.id.my_drawer_layout)


//setting navigation bar (show hamburger icon, open and close )
        actionBarDrawerToggle =
            ActionBarDrawerToggle(
                this,
                drawerLayout,
                db_toolbar,
                R.string.nav_open,
                R.string.nav_close
            )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)

        when (item.itemId) {
            R.id.nav_home -> {
                changeFragment(HomeFragment())
            }
            R.id.nav_science -> {
                setToolBarTitle("About Us")
                changeFragment(ScienceFragment())
            }
            R.id.nav_animal -> {
                setToolBarTitle("Animal")
                changeFragment(AnimalFragment())
            }
            R.id.nav_country -> {
                setToolBarTitle("Country")
                changeFragment(CountriesFragment())
            }
            R.id.nav_space -> {
                setToolBarTitle("Space Facts")
                changeFragment(SpaceFragment())
            }
            R.id.nav_love -> {
                setToolBarTitle("Love Facts")
                changeFragment(LoveFragment())
            }
            R.id.nav_body -> {
                setToolBarTitle("Body Facts")
                changeFragment(BodyFragment())
            }
            R.id.nav_share -> {
                val shareBody = "Download an app from google play store: appsums.com"
                val shareSub = "Nasim Testing app"
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                startActivity(shareIntent)
            }
            R.id.nav_rate -> {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=in.AajTak.headlines")
                    )
                )
            }
            R.id.nav_feedback -> {
                val shareEmail = "naseem@appsums.com"
                val shareBody = "Genuine Feedback"
                val shareSub = getString(R.string.app_name)
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, shareEmail)
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
                startActivity(shareIntent)
            }
            R.id.nav_about -> {
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setMessage(R.string.about_us)
                val alert = dialogBuilder.create()
                alert.setTitle("About Us")
                alert.show()
            }
        }
        return true
    }

    private fun changeFragment(frag: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container, frag).commit()
    }

    fun setToolBarTitle(title: String) {
        supportActionBar?.title = title
    }
}