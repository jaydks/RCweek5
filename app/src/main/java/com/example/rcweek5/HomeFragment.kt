package com.example.rcweek5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rcweek5.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        binding.rvTopmenu.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTopmenu.setHasFixedSize(true)
        binding.rvTopmenu.adapter = TopmenuAdapter(topmenuList)

        return binding.root
    }

}