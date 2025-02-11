package com.example.yeojeong

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yeojeong.Adapter.PlanRcvDateAdapter
import com.example.yeojeong.Adapter.PlanRcvDateDecoration
import com.example.yeojeong.Adapter.PlanViewRcvAdapter
import com.example.yeojeong.databinding.ActivityPlanViewBinding

class PlanViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding=ActivityPlanViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //계획 목록 리사이클러뷰
        binding.planViewRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.planViewRecyclerView.adapter = PlanViewRcvAdapter(savedInstanceState, mutableListOf<String>("테스트","테스트"));

        //날짜 리사이클러뷰
        binding.planViewDateRecyclerView.layoutManager = LinearLayoutManager(this).apply {orientation=LinearLayoutManager.HORIZONTAL}
        binding.planViewDateRecyclerView.adapter = PlanRcvDateAdapter(mutableListOf<String>("2/4","2/5","2/6","2/7","2/8"))
        binding.planViewDateRecyclerView.addItemDecoration(PlanRcvDateDecoration())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}