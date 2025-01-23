package com.example.yeojeong

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.yeojeong.Adapter.MainFragmentPagerAdapter
import com.example.yeojeong.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //뷰 바인딩 적용
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }

        //BottomNavigation 아이콘 틴트 적용 해제
        binding.mainBottomNavigation.itemIconTintList=null

        //ViewPager2 Adapter 연동
        binding.mainViewpager.adapter= MainFragmentPagerAdapter(this)

        //ViewPager2와 BottomNavigation 연동
        binding.mainBottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.page_home -> {
                    binding.mainViewpager.currentItem = 0
                    true
                }
                R.id.page_diary -> {
                    binding.mainViewpager.currentItem = 1
                    true
                }
                R.id.page_plan -> {
                    binding.mainViewpager.currentItem = 2
                    true
                }
                R.id.page_explore -> {
                    binding.mainViewpager.currentItem = 3
                    true
                }
                R.id.page_profile -> {
                    binding.mainViewpager.currentItem = 4
                    true
                }
                else -> {
                    false
                }
            }
        }

        binding.mainViewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.mainBottomNavigation.menu.getItem(position).isChecked = true
            }
        })
    }
}