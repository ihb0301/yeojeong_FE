package com.example.yeojeong.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yeojeong.databinding.RcvNotificationBinding

class NotificationRcvViewHolder(val binding: RcvNotificationBinding): RecyclerView.ViewHolder(binding.root)

class NotificationRcvAdapter(val list: MutableList<Pair<String,String>>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        NotificationRcvViewHolder(RcvNotificationBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as NotificationRcvViewHolder).binding

        binding.notificationContentText.setText(list.get(position).first)
        binding.notificationTimeText.setText(list.get(position).second)
    }

    override fun getItemCount(): Int = list.size
}