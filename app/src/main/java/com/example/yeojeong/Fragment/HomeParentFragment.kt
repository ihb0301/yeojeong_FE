package com.example.yeojeong.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yeojeong.R

class HomeParentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        childFragmentManager.beginTransaction().apply{
            replace(R.id.home_frame_layout,HomeFragment())
            commit()
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_parent, container, false)
    }
}