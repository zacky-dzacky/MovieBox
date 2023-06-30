package id.co.moviebox.home.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.co.moviebox.home.ui.TrendingFragment
import id.co.moviebox.home.ui.GenreFragment

class PagerAdapter(fm: FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> TrendingFragment()
            1 -> GenreFragment()
            else -> GenreFragment()
        }
    }
}