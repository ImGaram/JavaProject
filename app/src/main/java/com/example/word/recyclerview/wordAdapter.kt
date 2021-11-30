package com.example.word.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.word.R
import com.example.word.wordRecyclerview.vocabularyActivity


// 단어 탭의 프라그먼트 리사이클러뷰
class wordAdapter(val adapterList: ArrayList<WordItems>) : RecyclerView.Adapter<wordAdapter.CustomViewHolder>(){   // worditems 의 아이템들을 arraylist화, recyclerview의 adapter 상속
    // xml 화면을 연결하는 곳
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): wordAdapter.CustomViewHolder {
        // activity_recycler_view 을 가져와 어댑터에 붙임
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_recycler_view, parent, false)  // context : activity의 모든 정보
        return CustomViewHolder(view)
    }

    // onCreateViewHolder 을 사용
    override fun onBindViewHolder(holder: wordAdapter.CustomViewHolder, position: Int) {
        holder.profile.setImageResource(adapterList.get(position).profile)
        holder.day.text = adapterList.get(position).day
        holder.word.text = adapterList.get(position).word

        // 클릭시 다른 화면으로 이동
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, vocabularyActivity::class.java).putExtra("data",1)
            startActivity(holder.itemView.context, intent, null)
        }

        // 아이템들의 간격 조절
        val layoutParams = holder.itemView.layoutParams
        layoutParams.height = 340
        holder.itemView.requestLayout()
    }

    // 리스트의 개수 리턴
    override fun getItemCount(): Int {
        return adapterList.size
    }

    inner class CustomViewHolder(view:View): RecyclerView.ViewHolder(view) {    // recyclerview의 viewholder 상속
        val profile = itemView.findViewById<ImageView>(R.id.image_main)
        val day = itemView.findViewById<TextView>(R.id.day_text)
        val word = itemView.findViewById<TextView>(R.id.word_text)
    }
}