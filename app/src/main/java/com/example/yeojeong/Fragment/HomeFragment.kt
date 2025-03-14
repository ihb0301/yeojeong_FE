package com.example.yeojeong.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yeojeong.Adapter.HomeRcvPopularAdapter
import com.example.yeojeong.Adapter.HomeRcvRecentAdapter
import com.example.yeojeong.Adapter.HomeRcvRecentDecoration
import com.example.yeojeong.R
import com.example.yeojeong.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater)
        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.homeToolbar)
        setHasOptionsMenu(true)

        //리사이클러 뷰 임시 테스트용 리스트 2개
        val list1= mutableListOf<String>("사람1","사람2","사람3","사람4","사람5","사람6","사람7")
        val list2= mutableListOf<String>("본문1","본문2","본문3","본문4","본문5")

        //많이 조회된 일기 리사이클러 뷰
        binding.homePopularRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.homePopularRecyclerView.adapter= HomeRcvPopularAdapter(list2)

        //최근 일기 리사이클러 뷰
        binding.homeRecentRecyclerView.layoutManager = LinearLayoutManager(activity)
            .apply{ orientation=LinearLayoutManager.HORIZONTAL }
        binding.homeRecentRecyclerView.adapter= HomeRcvRecentAdapter(list1)
        binding.homeRecentRecyclerView.addItemDecoration(HomeRcvRecentDecoration(binding.root.context,list1.size))

        //parentFragmentManager.beginTransaction().replace(container!!.id,SearchFragment()).commit()

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home_toolbar_search->{
                parentFragmentManager.beginTransaction().apply{
                    replace(R.id.home_frame_layout,SearchFragment())
                    commit()
                }
            }
            R.id.home_toolbar_notification->{
                parentFragmentManager.beginTransaction().apply{
                    replace(R.id.home_frame_layout,NotificationFragment())
                    commit()
                }
            }
            else->{

            }
        }

        return super.onOptionsItemSelected(item)
    }
}