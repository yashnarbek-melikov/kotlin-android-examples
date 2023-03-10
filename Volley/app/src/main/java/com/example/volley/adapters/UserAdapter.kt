package com.example.volley.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.volley.databinding.ItemUserBinding
import com.example.volley.models.User

class UserAdapter : ListAdapter<User, UserAdapter.Vh>(MyDiffUtil()) {

    inner class Vh(var itemUserBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(itemUserBinding.root) {

        fun onBind(user: User) {
            itemUserBinding.apply {
                nameTv.text = user.name
                emailTv.text = user.email
            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }
}