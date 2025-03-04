package com.example.yeojeong.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yeojeong.Adapter.HomeRcvPopularAdapter
import com.example.yeojeong.R
import com.example.yeojeong.databinding.FragmentMypageBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MyPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyPageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentMypageBinding.inflate(inflater,container,false)

        binding.rcvMypage.layoutManager=LinearLayoutManager(activity)
        binding.rcvMypage.adapter=HomeRcvPopularAdapter(mutableListOf("1","2","3","4","5"))

        return binding.root
    }
}