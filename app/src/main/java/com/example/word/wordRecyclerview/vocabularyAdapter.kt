package com.example.word.wordRecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.word.R

// 단어 화면의 리사이클러뷰
class vocabularyAdapter(val vocaList : ArrayList<vocabularyItems>):
    RecyclerView.Adapter<vocabularyAdapter.VocaViewHolder>() {

    private var callbackListener: ClickCallbackListener? = null

//    val callbackListener = ClickCallbackListener { pos ->
//        val intent = Intent(holder.itemView.context, vocabularyActivity::class.java).putExtra("data",pos)
//        ContextCompat.startActivity(holder.itemView.context, intent, null)
//    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): vocabularyAdapter.VocaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.voca_item, parent, false)
        return VocaViewHolder(view)
    }

    override fun onBindViewHolder(holder: vocabularyAdapter.VocaViewHolder, position: Int) {
        holder.number.text = vocaList.get(position).number.toString()
        holder.word.text = vocaList.get(position).word
        holder.mean.text = vocaList.get(position).mean
        holder.value.text = vocaList.get(position).value
    }

    override fun getItemCount(): Int {
        return vocaList.size
    }

    inner class VocaViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val number = itemView.findViewById<TextView>(R.id.voca_number)
        val word = itemView.findViewById<TextView>(R.id.voca_word)
        val mean = itemView.findViewById<TextView>(R.id.voca_mean)
        val value = itemView.findViewById<TextView>(R.id.voca_value)
    }
}