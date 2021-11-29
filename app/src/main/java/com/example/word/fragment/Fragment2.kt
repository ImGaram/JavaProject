package com.example.word.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.word.R
import com.example.word.recyclerview.wordAdapter
import com.example.word.recyclerview.WordItems


class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val wordList = arrayListOf(
            WordItems(R.drawable.temp,1,  "Day 1","40개"),
            WordItems(R.drawable.temp,2,  "Day 2","40개"),
            WordItems(R.drawable.temp,3,  "Day 3","40개"),
            WordItems(R.drawable.temp,4,  "Day 4","44개"),
            WordItems(R.drawable.temp,5,  "Day 5","40개"),
            WordItems(R.drawable.temp,6,  "Day 6","42개"),
            WordItems(R.drawable.temp,7,  "Day 7","39개"),
            WordItems(R.drawable.temp,8,  "Day 8","40개"),
            WordItems(R.drawable.temp,9,  "Day 9","40개"),
            WordItems(R.drawable.temp,10, "Day 10","40개"),
            WordItems(R.drawable.temp,11, "Day 11","45개"),
            WordItems(R.drawable.temp,12, "Day 12","41개"),
            WordItems(R.drawable.temp,13, "Day 13","40개"),
            WordItems(R.drawable.temp,14, "Day 14","44개"),
            WordItems(R.drawable.temp,15, "Day 15","41개"),
            WordItems(R.drawable.temp,16, "Day 16","42개"),
            WordItems(R.drawable.temp,17, "Day 17","41개"),
            WordItems(R.drawable.temp,18, "Day 18","41개"),
            WordItems(R.drawable.temp,19, "Day 19","41개"),
            WordItems(R.drawable.temp,20, "Day 20","42개"),
            WordItems(R.drawable.temp,21, "Day 21","42개"),
            WordItems(R.drawable.temp,22, "Day 22","46개"),
            WordItems(R.drawable.temp,23, "Day 23","40개"),
            WordItems(R.drawable.temp,24, "Day 24","41개"),
            WordItems(R.drawable.temp,25, "Day 25","40개"),
            WordItems(R.drawable.temp,26, "Day 26","44개"),
            WordItems(R.drawable.temp,27, "Day 27","40개"),
            WordItems(R.drawable.temp,28, "Day 28","40개"),
            WordItems(R.drawable.temp,29, "Day 29","43개"),
            WordItems(R.drawable.temp,30, "Day 30","42개")
        )

        // Inflate the layout for this fragment
        val mainView = inflater.inflate(R.layout.activity_fragment2, container, false)
        val recyclerView: RecyclerView = mainView.findViewById(R.id.main_recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = wordAdapter(wordList)

        return mainView
    }
}