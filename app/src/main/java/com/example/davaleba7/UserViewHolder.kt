package com.example.davaleba7

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
class UserViewHolder(
    containerView: View,
    private val imageLoader: ImageLoader
): RecyclerView.ViewHolder(containerView) {
    private val userNameView: TextView
            by lazy { containerView.findViewById(R.id.name) }
    private val userEmailView: TextView
            by lazy { containerView.findViewById(R.id.email) }
    private val userImageView: ImageView
            by lazy { containerView.findViewById(R.id.image) }
    fun bindData(userData: User) {
        imageLoader.loadImage(userData.avatar, userImageView)
        userNameView.text=userData.firstName
        userEmailView.text=userData.email
    }
}