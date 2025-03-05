package com.example.yeojeong.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yeojeong.Adapter.HomeRcvPopularAdapter
import com.example.yeojeong.R
import com.example.yeojeong.databinding.FragmentMypageBinding

class MyPageFragment : Fragment() {

    /*
    0: 조회한 일기
    1: 좋아요한 일기
    2: 댓글 쓴 일기
     */
    private var DIARY_CATEGORY_NUM:Int = 0
    lateinit var binding: FragmentMypageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMypageBinding.inflate(inflater,container,false)

        binding.rcvMypage.layoutManager=LinearLayoutManager(activity)
        recyclerviewChange(binding.rcvMypage,
            DIARY_CATEGORY_NUM)

        binding.categoryButton1.setOnClickListener {
            DIARY_CATEGORY_NUM=0
            diaryCategoryChange(DIARY_CATEGORY_NUM)
            recyclerviewChange(binding.rcvMypage,
                DIARY_CATEGORY_NUM)
        }
        binding.categoryButton2.setOnClickListener {
            DIARY_CATEGORY_NUM=1
            diaryCategoryChange(DIARY_CATEGORY_NUM)
            recyclerviewChange(binding.rcvMypage,
                DIARY_CATEGORY_NUM)
        }
        binding.categoryButton3.setOnClickListener{
            DIARY_CATEGORY_NUM=2
            diaryCategoryChange(DIARY_CATEGORY_NUM)
            recyclerviewChange(binding.rcvMypage,
                DIARY_CATEGORY_NUM)
        }

        return binding.root
    }

    private fun recyclerviewChange(rcv: RecyclerView,categoryNum: Int){
        val mutableList: MutableList<String>
        when(categoryNum){
            0->{
                //조회한 일기
                mutableList=mutableListOf("1","2","3")
                rcv.adapter=HomeRcvPopularAdapter(mutableList)
            }
            1->{
                //좋아요한 일기
                mutableList=mutableListOf("1","2","3","4")
                rcv.adapter=HomeRcvPopularAdapter(mutableList)
            }
            2->{
                //댓글 쓴 일기
                mutableList=mutableListOf("1","2","3","4","5")
                rcv.adapter=HomeRcvPopularAdapter(mutableList)
            }
        }
    }

    private fun buttonColorChange(button: Button,selected: Boolean){
        if(selected){
            button.setBackgroundColor(resources.getColor(R.color.mypage_button_sel,null))
            button.setTextColor(resources.getColor(R.color.white,null))
        }else{
            button.setBackgroundColor(resources.getColor(R.color.mypage_button,null))
            button.setTextColor(resources.getColor(R.color.black,null))
        }
    }

    private fun diaryCategoryChange(categoryNum: Int){
        when(categoryNum){
            0->{
                buttonColorChange(binding.categoryButton1,true)
                buttonColorChange(binding.categoryButton2,false)
                buttonColorChange(binding.categoryButton3,false)
            }
            1->{
                buttonColorChange(binding.categoryButton1,false)
                buttonColorChange(binding.categoryButton2,true)
                buttonColorChange(binding.categoryButton3,false)

            }
            2->{
                buttonColorChange(binding.categoryButton1,false)
                buttonColorChange(binding.categoryButton2,false)
                buttonColorChange(binding.categoryButton3,true)

            }
        }
    }
}