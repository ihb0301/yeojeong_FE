package com.example.yeojeong.Adapter

import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yeojeong.R
import com.example.yeojeong.databinding.RcvPlanViewBinding
import com.example.yeojeong.databinding.RcvPlanViewDateBinding


class PlanViewRcvViewHolder(val binding: RcvPlanViewBinding): RecyclerView.ViewHolder(binding.root)
class PlanViewRcvDateViewHolder(val binding: RcvPlanViewDateBinding): RecyclerView.ViewHolder(binding.root)

class PlanViewRcvAdapter(val savedInstanceState: Bundle?, private val planList: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PlanViewRcvViewHolder(RcvPlanViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = planList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding= (holder as PlanViewRcvViewHolder).binding

        //첫 번째 인덱스가 아닐 경우 날짜 레이아웃을 표시하지 않는다
        if(position!=0){
            binding.rcvPlanViewLayout2.visibility=View.GONE
        }else{
            binding.dashlineTop.visibility = View.GONE
        }

        //맵 뷰 초기화
        binding.mapView.onCreate(savedInstanceState)
    }
}

class PlanRcvDateAdapter(val date: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var selectedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PlanViewRcvDateViewHolder(RcvPlanViewDateBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as PlanViewRcvDateViewHolder).binding

        if(position==0){
            binding.rcvPlanViewDateTextDate1.visibility=View.INVISIBLE
            binding.rcvPlanViewDateTextDate2.text="전체"
            binding.rcvPlanViewDateTextDate2.textSize=15f
        }else{
            if(selectedPosition==position){
                binding.rcvPlanViewDateTextDate2.text=date.get(position-1)
            }else{
                binding.rcvPlanViewDateTextDate2.text=date.get(position-1).split("/")[1]
            }

        }

        if(selectedPosition==position){
            binding.rcvPlanViewDateTextDate1.setTextColor(binding.root.context.resources.getColor(R.color.black))
            binding.rcvPlanViewDateTextDate2.setTextColor(binding.root.context.resources.getColor(R.color.black))
        }else{
            binding.rcvPlanViewDateTextDate1.setTextColor(Color.parseColor("#C1C1C1"))
            binding.rcvPlanViewDateTextDate2.setTextColor(Color.parseColor("#C1C1C1"))
        }

        binding.rcvPlanViewDateLayout.setOnClickListener {
            selectedPosition=position
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int = date.size
}

class PlanRcvDateDecoration(): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index=parent.getChildAdapterPosition(view)

        if(index==0) {
            outRect.left = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25f, parent.context.resources.displayMetrics)
                .toInt()
            outRect.right = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 21f, parent.context.resources.displayMetrics)
                .toInt()
        }else if(index==1) {
            outRect.right = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 42f, parent.context.resources.displayMetrics)
                .toInt()
        }else {
            outRect.right = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 51f, parent.context.resources.displayMetrics)
                .toInt()
        }
    }
}