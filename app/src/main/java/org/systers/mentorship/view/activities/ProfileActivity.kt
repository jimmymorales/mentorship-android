package org.systers.mentorship.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import org.systers.mentorship.R
import org.systers.mentorship.view.fragments.ProfileFragment

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if (savedInstanceState == null) {
            val title = getString(R.string.fragment_title_profile)
            supportFragmentManager.beginTransaction()
                .replace(R.id.contentFrame, ProfileFragment.newInstance(), title)
                .commit()
            supportActionBar?.title = title
            collapsingToolbarLayout?.title = title
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        menu.findItem(R.id.menu_profile)?.isVisible = false
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            R.id.menu_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            else -> false
        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
