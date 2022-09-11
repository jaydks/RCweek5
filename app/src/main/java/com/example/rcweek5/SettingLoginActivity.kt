package com.example.rcweek5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rcweek5.databinding.ActivitySettingMainBinding
import com.kakao.sdk.user.UserApiClient

class SettingLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logout.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if(error != null){
                    Toast.makeText(this, "로그아웃 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP)))
                    finish()
                }
            }
        }
    }
}