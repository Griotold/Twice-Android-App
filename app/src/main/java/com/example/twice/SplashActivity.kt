package com.example.twice

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

/**
 * 스플래시 화면은 1~2초가 가장 적당하며, 3초는 길게 느껴질 수 있습니다.
 * 앱이 본격적으로 시작되기 전에 "앱의 로고나 브랜드를 잠깐 보여주는 화면"
 * 앱이 초기 데이터를 로딩하거나 준비하는 동안 사용자에게 "앱이 잘 실행되고 있다"는 신호를 주기 위함
 * */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // android handler
        // 최근에는 Handler 대신 Coroutine이나 Lifecycle-aware 방식을 쓰기도 하지만,
        // 간단한 Splash 화면에서는 Handler도 많이 사용합니다.
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}