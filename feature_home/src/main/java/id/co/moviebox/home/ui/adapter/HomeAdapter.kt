package id.co.moviebox.home.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.moviebox.home.databinding.UserItemBinding
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.domain.entity.SearchUser
import java.util.ArrayList
import java.util.Locale

class HomeAdapter(
    private val mContext: Context,
    private val itemClick: (view: View, user: MovieDto) -> Unit
): PagingDataAdapter<MovieDto, HomeAdapter.UserViewHolder>(DiffCallback())  {

    private var filteredList: MutableList<MovieDto> = ArrayList()
    private var unFilteredList: MutableList<MovieDto> = ArrayList()

    class DiffCallback : DiffUtil.ItemCallback<MovieDto>() {
        override fun areItemsTheSame(oldItem: MovieDto, newItem: MovieDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MovieDto,
            newItem: MovieDto
        ): Boolean {
            return oldItem == newItem
        }
    }

    fun updatePosition(position: Int) {
        notifyItemChanged(position)
    }

    inner class UserViewHolder(
        val binding: UserItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: MovieDto) {
            Glide.with(mContext)
                .load(item.poster_path ?: "https://www.snapon.co.za/images/thumbs/default-image_550.png")
                .into(binding.imageView2)
            binding.textView5.text = if (item.name.isNullOrEmpty()) "Title Empty" else item.name
            binding.textView6.text = if (item.description.isNullOrEmpty()) "Description Empty" else item.description
            binding.clUser.setOnClickListener {
                itemClick.invoke(it, item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.let { holder.bindView(it) }
    }

    fun getFilteredResults(textFilter: String): List<MovieDto> {
        val results = arrayListOf<MovieDto>()
        filteredList.clear()
        filteredList.addAll(unFilteredList)
        for (item in filteredList) {
            if (item.id?.lowercase(Locale.US)
                    ?.contains(textFilter) == true
            ) {
                results.add(item)
            }
        }

        Log.w("filterResult", results.size.toString())
        if (results.size == 0) {
//            mListener.onSearchNotFound()
        }
        return results
    }

    fun setData(list: MutableList<MovieDto>) {
        unFilteredList = list
    }

    fun updateFullList(model: SearchUser) {
        for (i in unFilteredList.indices) {
            if (unFilteredList[i].id == model.id) {
//                val modelSelectCoin = UserDto()
//                modelSelectCoin.icon = model.icon
//                modelSelectCoin.name = model.name
//                modelSelectCoin.isSelected = model.isSelected
//                unFilteredList[i] = modelSelectCoin
            }
        }
    }
}