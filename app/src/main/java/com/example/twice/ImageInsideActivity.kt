package com.example.twice

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ImageInsideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        // 데이터 받기
        val data = intent.getStringExtra("data")

        val memberImage = findViewById<ImageView>(R.id.memberImageArea)

        // Toast.makeText(this, data, Toast.LENGTH_SHORT).show()

        if (data == "1") {
            memberImage.setImageResource(R.drawable.member_1)
        }

        if (data == "2") {
            memberImage.setImageResource(R.drawable.member_2)
        }

        if (data == "3") {
            memberImage.setImageResource(R.drawable.member_3)
        }

        if (data == "4") {
            memberImage.setImageResource(R.drawable.member_4)
        }

        if (data == "5") {
            memberImage.setImageResource(R.drawable.member_5)
        }

        if (data == "6") {
            memberImage.setImageResource(R.drawable.member_6)
        }

        if (data == "7") {
            memberImage.setImageResource(R.drawable.member_7)
        }

        if (data == "8") {
            memberImage.setImageResource(R.drawable.member_8)
        }

        if (data == "9") {
            memberImage.setImageResource(R.drawable.member_9)
        }



    }
}