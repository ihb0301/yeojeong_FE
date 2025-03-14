package com.example.yeojeong

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yeojeong.Adapter.CommentRcvAdapter
import com.example.yeojeong.databinding.ActivityCommentBinding

class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰바인딩
        binding=ActivityCommentBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener{
            finish()
        }

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            //adjustResize 적용 안되는 오류 해결
            val ime = insets.getInsets(WindowInsetsCompat.Type.ime())
            if(ime.bottom>0){
                binding.commentLayout.translationY = -((ime.bottom-systemBars.bottom).toFloat())
            }else{
                binding.commentLayout.translationY = 0f
            }

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //리사이클러뷰 연결
        binding.rcvComment.adapter=CommentRcvAdapter(mutableListOf("1","2","3","4","5"))
        binding.rcvComment.layoutManager=LinearLayoutManager(applicationContext)
        binding.rcvComment.addItemDecoration(DividerItemDecoration(applicationContext,LinearLayout.VERTICAL))
    }
}