package com.example.yeojeong.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yeojeong.Adapter.NotificationRcvAdapter
import com.example.yeojeong.R
import com.example.yeojeong.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentNotificationBinding.inflate(inflater,container,false)

        //툴바 적용
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.title="알림"

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.home_frame_layout,HomeFragment())
                commit()
            }
        }

        //리사이클러뷰 적용
        binding.rcvNotification.adapter=NotificationRcvAdapter(mutableListOf("닉네임님이 회원님의 친구 요청을 수락하였습니다" to "6시간","닉네임님이 회원님의 친구 요청을 수락하였습니다" to "1일","닉네임님이 회원님의 친구 요청을 수락하였습니다" to "3일"))
        binding.rcvNotification.layoutManager=LinearLayoutManager(activity)

        return binding.root
    }
}