package com.example.flyferrytask

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {


    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    private lateinit var navView: NavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.my_toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_drawer)

//        navView.menu.findItem(R.id.iclogin).isVisible = (user == null)
//        navView.menu.findItem(R.id.iclogout).isVisible = (user != null)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener{ item ->
            onNavItemSelect(item)
        }

        //  Initialize
        initialize()



        //  Set action bar
        setSupportActionBar(toolbar)



    }
    private fun initialize(){
        navView.setCheckedItem(R.id.ichome)
        onNavItemSelect(navView.menu.getItem(0))
    }

    //  On navigation item select
    private fun onNavItemSelect(item: MenuItem) : Boolean{
        invalidateOptionsMenu()
        return when (item.itemId) {
            R.id.ichome -> {

                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }
            R.id.icpost -> {

                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }
            R.id.icfriends -> {

                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }
            R.id.iclogout -> {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Logout")
                    .setMessage("Are you sure ?")
                    .setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                    }
                    .setNegativeButton("No", null)
                    .show()
                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }

            else -> false
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}