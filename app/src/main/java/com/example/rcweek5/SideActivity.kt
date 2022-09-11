package com.example.rcweek5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.view.View
import android.widget.Toast
import com.example.rcweek5.databinding.ActivitySideBinding
import com.kakao.sdk.user.UserApiClient

class SideActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finish()
        }


    }

    override fun onResume() {
        super.onResume()

        //쿠폰 -> "장" 사이즈 줄임
        val ssb = SpannableStringBuilder(binding.coupon2.text)
        ssb.setSpan(RelativeSizeSpan(0.9f), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.coupon2.text = ssb


        //로그인 정보 확인
        UserApiClient.instance.accessTokenInfo{ tokenInfo, error ->
            if (error != null) {
                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
            } else if (tokenInfo != null) {
                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                UserApiClient.instance.me { user, error ->
                    //로그인 상태라면 닉네임,포인트,쿠폰, 예매확인  보이기
                    binding.tvPleaselogin.text = "${user?.kakaoAccount?.profile?.nickname}님"
                    binding.signinorup.visibility = View.INVISIBLE
                    binding.pointandcoupon.visibility = View.VISIBLE
                    binding.notmembercheckbook.text = "예매확인"

                    binding.setting.setOnClickListener {
                        val intent = Intent(this, SettingLoginActivity::class.java)
                        startActivity(intent.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP)))
                        finish()
                    }
                }
            }
        }


        binding.close.setOnClickListener {
            finish()
        }



    }
}