package id.co.moviebox.home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import id.co.moviebox.base_component.ui.BaseFragment
import id.co.moviebox.home.R
import id.co.moviebox.home.databinding.HomeFragmentBinding
import id.co.moviebox.home.ui.adapter.HomeAdapter
import id.co.moviebox.home.vm.MainViewModel


class GenreFragment(override val layout: Int = R.layout.home_fragment): BaseFragment() {

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
                    .fromUri("app://detail/${user.name}".toUri())
                    .build()
                view.findNavController().navigate(req)
            }
        }
        binding.rvUsers.adapter = homeAdapter
        val arrayList = arrayListOf<String>("asdf", "asdf")
        val adapterList = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList)
        binding.spGender.adapter =
    }

    private fun setObserver() {

        viewModel.run {
            getGenres.listen(
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