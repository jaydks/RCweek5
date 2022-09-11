package com.example.rcweek5

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "c8c607a8672a51543e911582083a8b1a")
    }

}