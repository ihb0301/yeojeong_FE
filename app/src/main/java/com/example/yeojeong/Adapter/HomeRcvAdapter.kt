package com.example.yeojeong.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yeojeong.ArticleActivity
import com.example.yeojeong.R
import com.example.yeojeong.databinding.RcvHomePopularLayoutBinding
import com.example.yeojeong.databinding.RcvHomeRecentLayoutBinding

class HomeRcvPopularViewHolder(val binding: RcvHomePopularLayoutBinding): RecyclerView.ViewHolder(binding.root)
class HomeRcvRecentViewHolder(val binding: RcvHomeRecentLayoutBinding): RecyclerView.ViewHolder(binding.root)

//TODO 백엔드 구현 완료되면 String 대신 별도 객체 사용
class HomeRcvPopularAdapter(private val popularDiaryList: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        HomeRcvPopularViewHolder(RcvHomePopularLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = popularDiaryList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as HomeRcvPopularViewHolder).binding

        binding.rcvHomePopularLayout.setOnClickListener {
            val intent: Intent = Intent(binding.root.context, ArticleActivity::class.java)
            binding.root.context.startActivity(intent)
        }
    }
}

class HomeRcvRecentAdapter(private val recentDiaryList: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        HomeRcvRecentViewHolder(RcvHomeRecentLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as HomeRcvRecentViewHolder).binding

        binding.rcvHomeRecentLayoutName.setText(recentDiaryList.get(position))
        binding.rcvHomeRecentLayout.setOnClickListener {
            val intent: Intent = Intent(binding.root.context, ArticleActivity::class.java)
            binding.root.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = recentDiaryList.size
}

class HomeRcvRecentDecoration(val context: Context,val length: Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view)


        if(index==length-1){
            outRect.set(0,0,context.resources.getDimensionPixelSize(R.dimen.rcv_home_recent_margin),0,)
        }else if(index==0){
            outRect.set(context.resources.getDimensionPixelSize(R.dimen.rcv_home_recent_margin),0,context.resources.getDimensionPixelSize(R.dimen.rcv_home_recent_space),0,)
        }else{
            outRect.set(0,0,context.resources.getDimensionPixelSize(R.dimen.rcv_home_recent_space),0,)
        }
    }
}