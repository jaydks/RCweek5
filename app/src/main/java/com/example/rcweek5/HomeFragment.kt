package com.example.rcweek5

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rcweek5.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var date: String
    private val rvAdapter = MovieAdapter()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        val topmenuList = arrayListOf(
            Topmenus(R.drawable.top_1, "추석대피소"),
            Topmenus(R.drawable.top_2, "헌트 돌비"),
            Topmenus(R.drawable.top_3, "메가박스..."),
            Topmenus(R.drawable.top_4, "주변할인..."),
            Topmenus(R.drawable.top_5, "게임존"),
            Topmenus(R.drawable.top_6, "빵원티켓"),
            Topmenus(R.drawable.top_7, "빵원티켓"),
            Topmenus(R.drawable.top_8, "빵원티켓"),
            Topmenus(R.drawable.top_9, "오티북"),
            Topmenus(R.drawable.top_10, "신규/휴면"),
            Topmenus(R.drawable.top_11, "제휴/할인")
        )

        //rv : topmenu
        binding.rvTopmenu.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTopmenu.setHasFixedSize(true)
        binding.rvTopmenu.adapter = TopmenuAdapter(topmenuList)



        //어제 날짜 구하기
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -1) //변경하고 싶은 원하는 날짜 수를 넣어 준다.
        val timeToDate = calendar.time
        val formatter = SimpleDateFormat("yyyyMMdd") //날짜의 모양을 원하는 대로 변경 해 준다.
        date = formatter.format(timeToDate)


        val service = MovieApi.movieInterface
        service.getMovieData(getString(R.string.api_key), "${date}")
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d("TAG", response.body().toString())
                        val result = response.body()?.boxOfficeResult?.dailyBoxOfficeList
                        rvAdapter.submitList(result!!)
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("TAG", t.message.toString())

                }

            })


        //rv : movie
        binding.rvMovie.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMovie.adapter = rvAdapter


        return binding.root

    }


}