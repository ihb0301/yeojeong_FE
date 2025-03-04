package com.example.yeojeong.Fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yeojeong.Adapter.SearchRcvAdapter
import com.example.yeojeong.R
import com.example.yeojeong.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentSearchBinding.inflate(inflater,container,false)

        //툴바 적용
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.beginTransaction().apply{
                replace(R.id.home_frame_layout,HomeFragment())
                commit()
            }
        }

        //옵션 메뉴 추가
        setHasOptionsMenu(true)

        //리사이클러뷰 연동
        binding.rcvSearch.adapter= SearchRcvAdapter(mutableListOf("닉네임1" to "@아이디1","닉네임2" to "@아이디2","닉네임3" to "@아이디3","닉네임4" to "@아이디4","닉네임5" to "@아이디5"))
        binding.rcvSearch.layoutManager=LinearLayoutManager(activity)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_toolbar_menu,menu)
        val m=menu.findItem(R.id.search).actionView as SearchView
        //항상 펼쳐진 상태로 유지
        m.setIconifiedByDefault(false)
        //hint 문구 설정
        m.queryHint="검색"
        //배경 밑줄 제거
        m.findViewById<LinearLayout>(androidx.appcompat.R.id.search_plate).setBackgroundColor(Color.TRANSPARENT)
        //배경 변경
        m.setBackgroundResource(R.drawable.search_rect_radius)

        super.onCreateOptionsMenu(menu, inflater)
    }
}