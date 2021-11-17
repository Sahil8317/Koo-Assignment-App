package com.sahil.kooassignmentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sahil.accelerometer.Data

class PostAdaptor :RecyclerView.Adapter<PostAdaptor.PostHolder> (){
    private var postArray:List<Data>?=null

    class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var textViewTitle: TextView?=null
         var textViewDes:TextView?=null

        init {
            textViewTitle = itemView.findViewById(R.id.text_view_title)
            textViewDes = itemView.findViewById(R.id.text_view_description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)
        return PostHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val currentPost = postArray!![position]
        holder.textViewTitle!!.text = currentPost.title
        holder.textViewDes!!.text = currentPost.body
    }

    override fun getItemCount(): Int {
       return postArray!!.size
    }

    fun setPostArray(posts:List<Data>){
        this.postArray = posts
    }
}