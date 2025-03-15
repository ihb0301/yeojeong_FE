package com.example.yeojeong

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yeojeong.databinding.ActivitySplashBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivitySplashBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Todo 로그인 여부 체크 필요
        var login: Boolean = true

        val intentLogin:Intent = Intent(this,LoginActivity::class.java)
        val intentMain:Intent = Intent(this,MainActivity::class.java)
        GlobalScope.launch{
            delay(500L)
            if(login){
                startActivity(intentMain)
            }else{
                startActivity(intentLogin)
                runOnUiThread {
                    binding.logoImage.visibility = View.GONE
                    binding.splashProgressBar.visibility = View.VISIBLE
                }
                delay(500L)
            }

            finish()
        }

    }
}