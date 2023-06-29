package id.co.moviebox.feature_search.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.moviebox.search.databinding.SearchUserItemBinding
import id.co.moviebox.service_genre.domain.entity.SearchUser
import java.util.ArrayList
import java.util.Locale

class SearchUserAdapter(
    private val mContext: Context,
    private val itemClick: (view: View, user: SearchUser) -> Unit
): PagingDataAdapter<SearchUser, SearchUserAdapter.UserViewHolder>(DiffCallback())  {

    private var filteredList: MutableList<SearchUser> = ArrayList()
    private var unFilteredList: MutableList<SearchUser> = ArrayList()

    class DiffCallback : DiffUtil.ItemCallback<SearchUser>() {
        override fun areItemsTheSame(oldItem: SearchUser, newItem: SearchUser): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SearchUser,
            newItem: SearchUser
        ): Boolean {
            return oldItem == newItem
        }
    }

    fun updatePosition(position: Int) {
        notifyItemChanged(position)
    }

    inner class UserViewHolder(
        val binding: SearchUserItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: SearchUser) {
            Glide.with(mContext)
                .load(item.avatar_url)
                .circleCrop()
                .into(binding.imageView2)
            binding.textView5.text = item.login
            binding.textView6.text = item.repos_url
            binding.clUser.setOnClickListener {
                itemClick.invoke(it, item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            SearchUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.let { holder.bindView(it) }
    }

    fun getFilteredResults(textFilter: String): List<SearchUser> {
        val results = arrayListOf<SearchUser>()
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

    fun setData(list: MutableList<SearchUser>) {
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