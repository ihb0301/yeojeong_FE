package com.example.yeojeong.ApplicationClass

import android.app.Application
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.WindowManager
import android.widget.TextView
import com.example.yeojeong.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Yeojeong: Application() {
    companion object {
        //ToDo. 서버 주소 변경 필요
        val url: String = "https://maps.googleapis.com/maps/api/directions/json/";
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build()

        /*
            다이얼로그 생성을 위한 함수
            사용법 예시: Yeojeong.makeDialog(applicationContext ,"표시할 메시지")
        */
        fun makeDialog(context: Context,message: String){
            val dialog= Dialog(context)
            dialog.setContentView(R.layout.dialog_layout)
            dialog.window?.apply{
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
                    WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.S){
                    //안드로이드 버전 12 이상에서 블러 배경 적용
                    setBackgroundBlurRadius(80)
                }
            }
            dialog.findViewById<TextView>(R.id.message_text).setText(message)
            dialog.findViewById<TextView>(R.id.ok_button).setOnClickListener{
                dialog.hide()
            }
            dialog.show()
        }
    }
}