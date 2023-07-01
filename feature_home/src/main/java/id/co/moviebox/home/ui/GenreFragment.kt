package id.co.moviebox.home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import androidx.paging.PagingData
import id.co.moviebox.base_component.ui.BaseFragment
import id.co.moviebox.home.R
import id.co.moviebox.home.databinding.GenreFragmentBinding
import id.co.moviebox.home.ui.adapter.HomeAdapter
import id.co.moviebox.home.vm.MainViewModel
import kotlinx.coroutines.flow.collectLatest


class GenreFragment(override val layout: Int = R.layout.genre_fragment): BaseFragment() {

    private var hashList: HashMap<String, String> = hashMapOf()
    private var dataList: MutableList<String> = mutableListOf()
    val viewModel: MainViewModel by viewModels { viewModelFactory }
    lateinit var binding: GenreFragmentBinding
    var homeAdapter: HomeAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.run {
            getUsers()
        }
        binding = GenreFragmentBinding.inflate(layoutInflater)

        initUI()
        setObserver()
        return binding.root
    }

    private fun initUI() {
        homeAdapter = context?.let { HomeAdapter(it) { view, movies ->
                val req = NavDeepLinkRequest.Builder
                    .fromUri("app://detail/${movies.id}".toUri())
                    .build()
                view.findNavController().navigate(req)
            }
        }
        binding.rvUsers.adapter = homeAdapter
        binding.spGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                lifecycleScope.launchWhenStarted {
                    homeAdapter?.submitData(PagingData.empty())
                    if (hashList.size > 0) {
                        viewModel.getMoviesByGenre(
                            hashList[dataList[position]] ?: ""
                        ).collectLatest { homeAdapter?.submitData(it) }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }

    private fun setObserver() {

        viewModel.run {
            getGenres.listen(
                viewLifecycleOwner,
                onSuccess = {
                    //homeAdapter?.submitList(it)
                    it.forEach { data ->
                        hashList[data.name] = data.id
                        dataList.add(data.name)
                    }
                    val adapterList =
                        context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, dataList) }
                    binding.spGender.adapter = adapterList

                },
                onError = {
                    Log.d("Error", it.message)
                }
            )
        }
    }
}