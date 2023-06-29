package id.co.moviebox.detail.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import id.co.moviebox.base_component.ui.BaseFragment
import id.co.moviebox.detail.R
import id.co.moviebox.detail.databinding.DetailFragmentBinding
import id.co.moviebox.detail.vm.DetailViewModel
import id.co.moviebox.service_genre.domain.entity.DetailUser
import id.co.moviebox.service_genre.domain.entity.Genre

class DetailFragment(override val layout: Int = R.layout.detail_fragment) : BaseFragment() {

    val viewModel: DetailViewModel by viewModels { viewModelFactory }
    lateinit var userID: String

    lateinit var binding: DetailFragmentBinding
    var setFavorite = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(layoutInflater)

        arguments?.let {
            userID = it.getString("user_id") ?: ""
            Log.d("asdfasdf", userID)
            viewModel.run {
                getDetailLocal(userID)
            }
        }
        initUI()
        initObserver()
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.imgFavorite.setOnClickListener {
            binding.imgFavorite.setImageResource(R.drawable.ic_star_filled)
            setFavorite = true
            viewModel.run {
                getDetailUser(userID)
            }
        }
    }

    private fun initUI() {
        (activity as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHasOptionsMenu(false)
            setHomeButtonEnabled(false)
            title = ""
            setHasOptionsMenu(false)
        }
    }



    private fun initObserver() {
        viewModel.getDetailUser.listen(
            viewLifecycleOwner,
            onSuccess = {
                showProfile(it)
                if (setFavorite) {
                    val user = Genre(
                        it.id,
                        it.name
                    )
                    viewModel.setAsFavorite(user)
                }
            },
            onError = {
                      Log.d("asdfasdf", it.message)
            },
            onComplete = {
                Log.d("asdfasdf", "asdf")
            }
        )

        viewModel.setFavorite.listen(
            viewLifecycleOwner,
            onSuccess = {
                setFavoriteStatus(true)

            },
            onError = {
                setFavoriteStatus(false)
            },
            onComplete = {

            }
        )

        viewModel.getDetailLocal.listen(
            viewLifecycleOwner,
            onSuccess = {
                if (it.id.isEmpty()) {
                    setFavoriteStatus(false)
                } else {
                    setFavoriteStatus(true)
                }

                viewModel.getDetailUser(userID)
            },
            onError = {
                setFavoriteStatus(false)
                viewModel.getDetailUser(userID)
            }
        )
    }

    private fun setFavoriteStatus(status: Boolean) {
        setFavorite = status
        if (status) {
            binding.imgFavorite.setImageResource(R.drawable.ic_star_filled)
        } else {
            binding.imgFavorite.setImageResource(R.drawable.ic_star_empty)
        }

    }

    private fun showProfile(user: DetailUser) {
        binding.apply {
            context?.let {
                Glide.with(it)
                    .load(user.avatar_url)
                    .circleCrop()
                    .into(binding.imgUser)
            }
            tvLogin.text = user.login
            tvUsername.text = user.repos_url
            tvBio.text = user.type
        }
    }


}