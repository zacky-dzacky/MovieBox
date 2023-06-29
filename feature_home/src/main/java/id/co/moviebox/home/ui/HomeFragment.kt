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
import id.co.moviebox.home.databinding.HomeFragmentBinding
import id.co.moviebox.home.ui.adapter.HomeAdapter
import id.co.moviebox.home.vm.MainViewModel


class HomeFragment(override val layout: Int = R.layout.home_fragment): BaseFragment() {

    val viewModel: MainViewModel by viewModels { viewModelFactory }
    lateinit var binding: HomeFragmentBinding
    var homeAdapter: HomeAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.run {
            getUsers()
        }
        binding = HomeFragmentBinding.inflate(layoutInflater)

        initUI()
        setObserver()
        return binding.root
    }

    private fun initUI() {
        homeAdapter = context?.let { HomeAdapter(it) { view, user ->
                val req = NavDeepLinkRequest.Builder
                    .fromUri("app://detail/${user.login}".toUri())
                    .build()
                view.findNavController().navigate(req)
            }
        }
        binding.rvUsers.adapter = homeAdapter
    }

    private fun setObserver() {

        viewModel.run {
            getUsers.listen(
                viewLifecycleOwner,
                onSuccess = {
                    homeAdapter?.submitList(it)

                },
                onError = {
                    Log.d("Error", it.message)
                }
            )
        }
    }
}