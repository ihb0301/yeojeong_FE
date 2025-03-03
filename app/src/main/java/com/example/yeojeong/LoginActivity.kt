package com.example.yeojeong

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yeojeong.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding=ActivityLoginBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mainIntent:Intent = Intent(this,MainActivity::class.java)
        binding.loginButton.setOnClickListener{
            //Todo 로그인 성공 여부 체크하는 기능 구현 필요
            startActivity(mainIntent)
            finish()
        }

        val findPwIntent:Intent = Intent(this,FindPwActivity::class.java)
        binding.passwordFindText.setOnClickListener{
            startActivity(findPwIntent)
        }


    }
}