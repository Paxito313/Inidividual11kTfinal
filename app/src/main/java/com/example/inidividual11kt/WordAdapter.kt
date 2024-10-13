package com.example.inidividual11kt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(
    private val wordList: List<String>,
    private val context: Context,
    private val listener: SendWord
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val textView: TextView = itemView.findViewById(R.id.text_view_word)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(word: String) {
            textView.text = word
        }

        override fun onClick(v: View?) {
            listener.sendWord(wordList[layoutPosition])
        }
    }

    interface SendWord {
        fun sendWord(word: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordList[position])
    }

    override fun getItemCount(): Int = wordList.size
}
