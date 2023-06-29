package id.co.moviebox.feature_search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import id.co.moviebox.base_component.ui.BaseFragment
import id.co.moviebox.feature_search.vm.SearchViewModel
import id.co.moviebox.search.R
import id.co.moviebox.search.databinding.SearchFragmentBinding
import kotlinx.coroutines.flow.collectLatest

class SearchFragment(
    override val layout: Int = R.layout.search_fragment
): BaseFragment() {

    private lateinit var binding: SearchFragmentBinding
    private val viewModel: SearchViewModel by viewModels { viewModelFactory }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = SearchFragmentBinding.inflate(layoutInflater)


        val adapter = context?.let { SearchUserAdapter(it) { view, user ->
            val req = NavDeepLinkRequest.Builder
                .fromUri("app://detail/${user.id}".toUri())
                .build()
            view.findNavController().navigate(req)
        }
        }
        binding.rvSearch.adapter = adapter


        arguments?.let {
            val query = it.getString("query") ?: ""
            lifecycleScope.launchWhenStarted {
                viewModel.searchUserByQuery(query).collectLatest { adapter?.submitData(it) }
            }
        }
        setObserver()
        return binding.root
    }

    private fun setObserver() {
//        val adapter = context?.let { SearchUserAdapter(it) { view, user ->
//                val req = NavDeepLinkRequest.Builder
//                    .fromUri("app://detail/${user.login}".toUri())
//                    .build()
//                view.findNavController().navigate(req)
//            }
//        }
//        binding.rvSearch.adapter = adapter
        viewModel.run {
//            searchUser.listen(
//                viewLifecycleOwner,
//                onSuccess = {
//                    Log.d("SubmitList", "${it.size}")
//                    adapter?.submitList(it)
//                },
//                onError = {
//                    Log.d("ErrorList", it.message)
//                },
//            )
        }
    }
}