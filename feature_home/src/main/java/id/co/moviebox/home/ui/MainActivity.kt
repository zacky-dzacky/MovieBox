package id.co.moviebox.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import id.co.moviebox.base_component.ui.BaseFragment
import id.co.moviebox.home.R
import id.co.moviebox.home.databinding.ActivityMainBinding
import id.co.moviebox.home.ui.adapter.PagerAdapter

class MainActivity(override val layout: Int = R.layout.activity_main) : BaseFragment() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FragmentStateAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityMainBinding.inflate(inflater, container, false)

        initUI()
//        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        return binding.root
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.menu_search, menu)
//
//        val searchItem: MenuItem? = menu?.findItem(R.id.app_bar_search)
//        val searchManager = requireContext().getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        val searchView: SearchView? = searchItem?.actionView as SearchView
//
//        searchView?.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
//
//
////        binding.toolbar.addView(searchView)
//
//    }

    private fun initUI() {
//        setHasOptionsMenu(true)
//        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        adapter = PagerAdapter(context as FragmentActivity)
        binding.apply {
            mainNav.adapter = adapter
            mainNav.offscreenPageLimit = 2
        }
        TabLayoutMediator(binding.tabLayout, binding.mainNav) { tab, position ->
            when (position) {
                0 -> tab.text = "Movie"
                1 -> tab.text = "asdf`"
            }
        }.attach()
    }
}