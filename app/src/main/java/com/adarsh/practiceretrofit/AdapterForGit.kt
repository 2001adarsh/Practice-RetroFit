package com.adarsh.practiceretrofit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cs.view.*

class AdapterForGit(val arra: List<User>?) : RecyclerView.Adapter<AdapterForGit.AdapterViewHolder>() {

    class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_cs, parent, false)
        return AdapterViewHolder(item)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.itemView.user_name.text = arra?.get(position)?.id.toString()
        holder.itemView.name_.text = arra?.get(position)?.login
        Picasso.get().load(arra?.get(position)?.avatarUrl).into(holder.itemView.image_)
    }

    override fun getItemCount(): Int = arra!!.size
}