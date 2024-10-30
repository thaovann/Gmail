package com.example.gmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Email(val subject: String, val content: String, val time: String)

class EmailAdapter(private val emailList: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectTextView: TextView = itemView.findViewById(R.id.email_subject)
        val contentTextView: TextView = itemView.findViewById(R.id.email_content)
        val timeTextView: TextView = itemView.findViewById(R.id.email_time) // Add time TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.subjectTextView.text = email.subject
        holder.contentTextView.text = email.content
        holder.timeTextView.text = email.time // Set the time
    }

    override fun getItemCount(): Int {
        return emailList.size
    }
}
