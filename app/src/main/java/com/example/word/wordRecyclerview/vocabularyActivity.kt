package com.example.word.wordRecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.word.MainPage
import com.example.word.R
import com.example.word.recyclerview.WordItems
import kotlinx.android.synthetic.main.activity_vocabulary.*

class vocabularyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary)

        back_img.setOnClickListener {
            val intent = Intent(this,MainPage::class.java)
            startActivity(intent)
        }

        val wordList : Array<String> = resources.getStringArray(R.array.Day01Word)
        val meaningList : Array<String> = resources.getStringArray(R.array.Day1_meaning)
        val recyclerview: RecyclerView = findViewById(R.id.voca_recyclerview)

        val mylist = arrayListOf<vocabularyItems>()
        for (i in 0 until wordList.size) {
            val data = vocabularyItems(i+1,wordList[i],meaningList[i])
            mylist.add(data)
        }
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = vocabularyAdapter(mylist)
    }
}