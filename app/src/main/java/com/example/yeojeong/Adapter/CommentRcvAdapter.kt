package com.example.yeojeong.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yeojeong.databinding.RcvCommentBinding

class CommentRcvViewHolder(val binding: RcvCommentBinding): RecyclerView.ViewHolder(binding.root)

class CommentRcvAdapter(val item: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        CommentRcvViewHolder(RcvCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding=(holder as CommentRcvViewHolder).binding
    }

    override fun getItemCount(): Int = item.size
}