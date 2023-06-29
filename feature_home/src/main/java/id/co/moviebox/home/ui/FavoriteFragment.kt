package id.co.moviebox.home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import id.co.moviebox.base_component.ui.BaseFragment
import id.co.moviebox.home.R
import id.co.moviebox.home.databinding.FavoriteFragmentBinding
import id.co.moviebox.home.ui.adapter.FavoriteAdapter
import id.co.moviebox.home.vm.MainViewModel

class FavoriteFragment(override val layout: Int = R.layout.favorite_fragment): BaseFragment() {

    val viewModel: MainViewModel by viewModels { viewModelFactory }
    lateinit var binding: FavoriteFragmentBinding
    var favoriteAdapter: FavoriteAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.run {
            getFavoriteUsers()
        }
        binding = FavoriteFragmentBinding.inflate(layoutInflater)
        initUI()
        initListener()
        setObservers()
        return binding.root
    }

    private fun initListener() {
        binding.swFavorite.setOnRefreshListener {
            viewModel.run {
                getFavoriteUsers()
            }
        }
    }

    private fun initUI() {
        favoriteAdapter = context?.let { FavoriteAdapter(it) { view, user ->
            val req = NavDeepLinkRequest.Builder
                .fromUri("app://detail/${user.name}".toUri())
                .build()
            view.findNavController().navigate(req)
        }
        }
        binding.rvFavorite.adapter = favoriteAdapter
    }

    private fun setObservers() {
        viewModel.run {
            getFavoriteUsers.listen(
                viewLifecycleOwner,
                onSuccess = {
                    favoriteAdapter?.submitList(it)
                    binding.swFavorite.isRefreshing = false
                },
                onError = {
                    binding.swFavorite.isRefreshing = false
                    Log.d("Error", it.message)
                },
                onComplete = {binding.swFavorite.isRefreshing = false}
            )
        }
    }
}