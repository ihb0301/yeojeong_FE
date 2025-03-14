package com.example.yeojeong

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_article)

        findViewById<ImageButton>(R.id.articlePlanViewButton).setOnClickListener {
            val intent: Intent = Intent(this,PlanViewActivity::class.java)
            startActivity(intent)
        }

        findViewById<LinearLayout>(R.id.article_heart_layout).setOnClickListener {
            //Todo. 공감 아이콘 눌렀을 때 동작
        }

        findViewById<LinearLayout>(R.id.article_comment_layout).setOnClickListener {
            val intent: Intent = Intent(this,CommentActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}