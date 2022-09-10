package com.example.rcweek5


import com.squareup.moshi.Json

data class BoxOfficeResult(
    @Json(name = "boxofficeType")
    val boxofficeType: String?,
    @Json(name = "dailyBoxOfficeList")
    val dailyBoxOfficeList: List<DailyBoxOffice?>?,
    @Json(name = "showRange")
    val showRange: String?
)