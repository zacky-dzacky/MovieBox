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
import id.co.moviebox.service_genre.domain.entity.User
import java.util.ArrayList
import java.util.Locale

class HomeAdapter(
    private val mContext: Context,
    private val itemClick: (view: View, user: User) -> Unit
): ListAdapter<User, HomeAdapter.UserViewHolder>(DiffCallback())  {

    private var filteredList: MutableList<User> = ArrayList()
    private var unFilteredList: MutableList<User> = ArrayList()

    class DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: User,
            newItem: User
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

        fun bindView(item: User) {
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
            UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    fun getFilteredResults(textFilter: String): List<User> {
        val results = arrayListOf<User>()
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

    fun setData(list: MutableList<User>) {
        unFilteredList = list
    }

    fun updateFullList(model: User) {
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