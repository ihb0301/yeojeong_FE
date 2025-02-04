package com.example.yeojeong.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.yeojeong.Fragment.DiaryFragment
import com.example.yeojeong.Fragment.HomeFragment
import com.example.yeojeong.Fragment.PlanFragment
import com.example.yeojeong.Fragment.ProfileFragment

class MainFragmentPagerAdapter(activity : FragmentActivity) : FragmentStateAdapter(activity){
    val fragment: List<Fragment>
    init{
        fragment=listOf(
            HomeFragment(), DiaryFragment(), PlanFragment(), ProfileFragment()
        )
    }

    override fun getItemCount(): Int=fragment.size

    override fun createFragment(position: Int): Fragment=fragment[position]
}