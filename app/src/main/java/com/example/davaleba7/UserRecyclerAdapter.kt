package com.example.davaleba7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserRecyclerAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<UserViewHolder>() {
    private val userData = mutableListOf<User>()
    fun setData(userData: List<User>) {
        this.userData.clear()
        this.userData.addAll(userData)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): UserViewHolder {
        val view = layoutInflater.inflate(
            R.layout.item_user,
            parent, false)
        return UserViewHolder(view,imageLoader)
    }
    override fun getItemCount() = userData.size
    override fun onBindViewHolder(holder: UserViewHolder,
                                  position: Int) {
        holder.bindData(userData[position])
    }
}