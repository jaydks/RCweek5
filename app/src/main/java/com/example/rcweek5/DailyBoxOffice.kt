package com.example.rcweek5


import com.squareup.moshi.Json

data class DailyBoxOffice(
    @Json(name = "audiAcc")
    val audiAcc: String?,
    @Json(name = "audiChange")
    val audiChange: String?,
    @Json(name = "audiCnt")
    val audiCnt: String?,
    @Json(name = "audiInten")
    val audiInten: String?,
    @Json(name = "movieCd")
    val movieCd: String?,
    @Json(name = "movieNm")
    val movieNm: String?,
    @Json(name = "openDt")
    val openDt: String?,
    @Json(name = "rank")
    val rank: String?,
    @Json(name = "rankInten")
    val rankInten: String?,
    @Json(name = "rankOldAndNew")
    val rankOldAndNew: String?,
    @Json(name = "rnum")
    val rnum: String?,
    @Json(name = "salesAcc")
    val salesAcc: String?,
    @Json(name = "salesAmt")
    val salesAmt: String?,
    @Json(name = "salesChange")
    val salesChange: String?,
    @Json(name = "salesInten")
    val salesInten: String?,
    @Json(name = "salesShare")
    val salesShare: String?,
    @Json(name = "scrnCnt")
    val scrnCnt: String?,
    @Json(name = "showCnt")
    val showCnt: String?
)