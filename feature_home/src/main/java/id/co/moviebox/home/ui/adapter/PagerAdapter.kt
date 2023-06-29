package id.co.moviebox.home.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.co.moviebox.home.ui.FavoriteFragment
import id.co.moviebox.home.ui.HomeFragment

class PagerAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> FavoriteFragment()
            else -> HomeFragment()
        }
    }
}