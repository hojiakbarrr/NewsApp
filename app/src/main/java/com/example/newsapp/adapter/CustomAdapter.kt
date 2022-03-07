package com.example.newsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.Articles
import com.squareup.picasso.Picasso

class CustomAdapter(private val mList: List<Articles>?, val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(title: String)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList?.get(position)


        Picasso.get().load(mList?.get(position)?.urlToImage)
            .into(holder.imageView)
        holder.title.text = mList!![position].title
        holder.description.text = mList!![position].description
        holder.date.text = mList!![position].publishedAt
        holder.source.text = mList!![position].source.name
        holder.author.text = mList!![position].author


    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.main_photo)
        val title: TextView = itemView.findViewById(R.id.titl_e)
        val description: TextView = itemView.findViewById(R.id.descrip)
        val source: TextView = itemView.findViewById(R.id.source)
        val date: TextView = itemView.findViewById(R.id.date)
        val author: TextView = itemView.findViewById(R.id.author)

        init {
            ItemView.setOnClickListener {
                mList?.get(position)?.let { it -> itemClickListener.onItemClick(it.url) }
            }
        }

    }

}