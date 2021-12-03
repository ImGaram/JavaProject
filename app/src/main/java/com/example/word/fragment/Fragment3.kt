package com.example.word.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.word.R
import com.example.word.Room.RecyclerAdapter
import com.example.word.Room.RoomMemo
import com.example.word.Room.RoomMemoDAO
import kotlinx.android.synthetic.main.activity_fragment3.*

class Fragment3 : Fragment() {
    val memoList = mutableListOf<RoomMemo>()
    lateinit var memoDAO: RoomMemoDAO
    lateinit var memoAdapter:RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          //  helper = Room.databaseBuilder(MainPage, RoomHelper::class.java, "room_db")
            //    .allowMainThreadQueries()
              //  .build()

        lateinit var helper:com.example.word.Room.RoomHelper

        memoDAO = helper.roomMemoDao()
        memoAdapter = RecyclerAdapter(memoList)

        recyclerMemo.adapter = memoAdapter
       // recyclerMemo.layoutManager = LinearLayoutManager(this)

        buttonSave.setOnClickListener {
            val content = editMemo.text.toString()
            if(content.isNotEmpty()) {
                val datetime = System.currentTimeMillis()
                val memo = RoomMemo(content, datetime)
                memoDAO.insert(memo)

                refreshAdapter()
            }
        }

        return inflater.inflate(R.layout.activity_fragment3, container, false)
    }
    fun refreshAdapter(){

        memoList.clear()
        memoList.addAll(memoDAO.getAll())
        memoAdapter.notifyDataSetChanged()
    }
}