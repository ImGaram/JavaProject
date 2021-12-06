package com.example.word.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.word.R
import com.example.word.Room.RecyclerAdapter
import com.example.word.Room.RoomHelper
import com.example.word.Room.RoomMemo
import com.example.word.Room.RoomMemoDAO
import com.example.word.databinding.ActivityFragment3Binding

class Fragment3 : Fragment() {
    val binding by lazy { ActivityFragment3Binding.inflate(layoutInflater) }
    val memoList = mutableListOf<RoomMemo>()
    lateinit var memoDAO: RoomMemoDAO
    lateinit var memoAdapter:RecyclerAdapter
    lateinit var helper:RoomHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_fragment3, container, false)
        helper = Room.databaseBuilder(requireContext(), RoomHelper::class.java, "room_db")
            .allowMainThreadQueries()
            .build()

        memoDAO = helper.roomMemoDao()
        memoAdapter = RecyclerAdapter(memoList)
        refreshAdapter()

        with(binding) {
            recyclerMemo.adapter = memoAdapter
            recyclerMemo.layoutManager = LinearLayoutManager(requireContext())

            buttonSave.setOnClickListener {
                val content = editMemo.text.toString()
                if(content.isNotEmpty()) {
                    val datetime = System.currentTimeMillis()
                    val memo = RoomMemo(content, datetime)
                    memoDAO.insert(memo)

                    refreshAdapter()
                }
            }
        }

        return view
    }

    fun refreshAdapter(){
        memoList.clear()
        memoList.addAll(memoDAO.getAll())
        memoAdapter.notifyDataSetChanged()
    }
}