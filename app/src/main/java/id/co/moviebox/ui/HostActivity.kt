package id.co.moviebox.ui

import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.net.toUri
import androidx.core.view.MenuItemCompat
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.NavHostFragment
import id.co.moviebox.R
import id.co.moviebox.base_component.ui.BaseActivity
import id.co.moviebox.databinding.HostActivityBinding

class HostActivity(layout: Int = R.layout.host_activity): BaseActivity(layout) {

    private lateinit var binding: HostActivityBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(id.co.moviebox.home.R.menu.menu_search, menu)

        val searchItem: MenuItem? = menu.findItem(id.co.moviebox.home.R.id.app_bar_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView = searchItem?.actionView as SearchView

        val v = searchView.findViewById<View>(androidx.appcompat.R.id.search_plate)
        v.setBackgroundColor(Color.parseColor("#FFFFFF"))

        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                val navHost = supportFragmentManager.findFragmentById(R.id.fragment)
                        as NavHostFragment
                val navController = navHost.navController
//                navController.navigate(R.id.searchFragment)

                val req = NavDeepLinkRequest.Builder
                    .fromUri("app://search/$query".toUri())
                    .build()
                navController.navigate(req)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

        MenuItemCompat.setOnActionExpandListener(
            searchItem,
            object : MenuItemCompat.OnActionExpandListener {
                override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                    return true
                }

                override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                    navigateToHome()
                    return true
                }
            })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                navigateToHome()
                setToolbarHome()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setToolbarHome() {
        toolbar.title = "Github assdddf"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeButtonEnabled(false)
    }

    private fun navigateToHome() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragment)
                as NavHostFragment
        val navController = navHost.navController
        navController.popBackStack()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setToolbarHome()
    }
}