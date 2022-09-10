package com.example.rcweek5


import com.squareup.moshi.Json

data class MovieResponse(
    @field:Json(name = "boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult?
)

data class BoxOfficeResult(
    @field:Json(name = "boxofficeType")
    val boxofficeType: String?,
    @field:Json(name = "dailyBoxOfficeList")
    val dailyBoxOfficeList: List<DailyBoxOffice?>?,
    @field:Json(name = "showRange")
    val showRange: String?
)

data class DailyBoxOffice(
    @field:Json(name = "audiAcc")
    val audiAcc: String?,
    @field:Json(name = "audiChange")
    val audiChange: String?,
    @field:Json(name = "audiCnt")
    val audiCnt: String?,
    @field:Json(name = "audiInten")
    val audiInten: String?,
    @field:Json(name = "movieCd")
    val movieCd: String?,
    @field:Json(name = "movieNm")
    val movieNm: String?,
    @field:Json(name = "openDt")
    val openDt: String?,
    @field:Json(name = "rank")
    val rank: String?,
    @field:Json(name = "rankInten")
    val rankInten: String?,
    @field:Json(name = "rankOldAndNew")
    val rankOldAndNew: String?,
    @field:Json(name = "rnum")
    val rnum: String?,
    @field:Json(name = "salesAcc")
    val salesAcc: String?,
    @field:Json(name = "salesAmt")
    val salesAmt: String?,
    @field:Json(name = "salesChange")
    val salesChange: String?,
    @field:Json(name = "salesInten")
    val salesInten: String?,
    @field:Json(name = "salesShare")
    val salesShare: String?,
    @field:Json(name = "scrnCnt")
    val scrnCnt: String?,
    @field:Json(name = "showCnt")
    val showCnt: String?
)

