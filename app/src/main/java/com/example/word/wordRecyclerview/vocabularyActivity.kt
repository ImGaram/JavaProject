package com.example.word.wordRecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.word.MainPage
import com.example.word.R
import com.example.word.recyclerview.wordAdapter
import kotlinx.android.synthetic.main.activity_vocabulary.*
import java.util.ArrayList

class vocabularyActivity : AppCompatActivity() {

    val wordList = resources.getStringArray(R.array.Day1_word)
    val meaningList = resources.getStringArray(R.array.Day1_meaning)
    lateinit var stringItem: ArrayList<vocabularyItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary)

        back_img.setOnClickListener {
            val intent = Intent(this,MainPage::class.java)
            startActivity(intent)
        }

        for (i in wordList.indices) {
            stringItem[i] = vocabularyItems(i,wordList[i],meaningList[i],"[n]")
        }

        val recyclerview: RecyclerView = findViewById(R.id.voca_recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = vocabularyAdapter(stringItem)
    }
}