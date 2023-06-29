package id.co.moviebox.home.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.moviebox.home.databinding.UserItemBinding
import id.co.moviebox.service_genre.domain.entity.Genre
import java.util.ArrayList
import java.util.Locale

class FavoriteAdapter(
    private val mContext: Context,
    private val itemClick: (view: View, user: Genre) -> Unit
): ListAdapter<Genre, FavoriteAdapter.UserViewHolder>(DiffCallback())  {

    private var filteredList: MutableList<Genre> = ArrayList()
    private var unFilteredList: MutableList<Genre> = ArrayList()

    class DiffCallback : DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Genre,
            newItem: Genre
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

        fun bindView(item: Genre) {

            binding.textView5.text = item.id
            binding.textView6.text = item.name
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
        holder.bindView(getItem(position))
    }

    fun getFilteredResults(textFilter: String): List<Genre> {
        val results = arrayListOf<Genre>()
        filteredList.clear()
        filteredList.addAll(unFilteredList)
        for (item in filteredList) {
            if (item.id.lowercase(Locale.US)
                .contains(textFilter)
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

    fun setData(list: MutableList<Genre>) {
        unFilteredList = list
    }

    fun updateFullList(model: Genre) {
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