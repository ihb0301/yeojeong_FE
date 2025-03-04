package com.example.yeojeong.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yeojeong.databinding.RcvSearchRecentBinding

class SearchRcvViewHolder(val binding: RcvSearchRecentBinding): RecyclerView.ViewHolder(binding.root)

class SearchRcvAdapter(val list: MutableList<Pair<String,String>>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder=
        SearchRcvViewHolder(RcvSearchRecentBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as SearchRcvViewHolder).binding

        binding.nicknameText.setText(list.get(position).first)
        binding.idText.setText(list.get(position).second)
    }

    override fun getItemCount(): Int = list.size
}