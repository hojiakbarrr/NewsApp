package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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

//        https://s0.rbk.ru/v6_top_pics/media/img/2/08/756463798110082.jpg
//
//        https://icdn.lenta.ru/images/2022/03/04/11/20220304111116414/share_7805c8b65dea50129a2168e45a601ed0.jpg
        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
//        holder.textView.text = ItemsViewModel?.title

    }

    // return the number of the items in the list
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

        //        val textView: TextView = itemView.findViewById(R.id.textView)
        init {
            ItemView.setOnClickListener {
                mList?.get(position)?.let { it -> itemClickListener.onItemClick(it.url) }
            }
        }

    }

}