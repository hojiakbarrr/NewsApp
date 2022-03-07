package com.example.newsapp.spor

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.ui.WebViewActivity
import com.example.newsapp.adapter.CustomAdapter
import com.example.newsapp.api.ApiInterface
import com.example.newsapp.model.News
import com.example.newsapp.static.Ssylka
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SportsFragment : Fragment() {

    companion object {
        fun newInstance() = SportsFragment()
    }

    private lateinit var viewModel: SportsViewModel
    lateinit var recyclerview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val v = inflater.inflate(R.layout.sports_fragment, container, false)

        recyclerview = v.findViewById(R.id.recSport)

        recyclerview.layoutManager = GridLayoutManager(requireContext(),1)

        val ss =  Ssylka.allUsers

        val apiInterface = ApiInterface.create().getNewsCategory(ss,
            ApiInterface.SPORT,100,
            ApiInterface.API_KEY)

        apiInterface.enqueue( object : Callback<News>, CustomAdapter.ItemClickListener {
            override fun onResponse(call: Call<News>?, response: Response<News>?) {
                val adapter = CustomAdapter(response?.body()?.articles,this)

                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter
                Log.d("testLogs","OnResponse Success ${response?.body()?.articles}")
            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.d("testLogs","OnResponse Success ${t?.message}")

            }

            override fun onItemClick(title: String) {
                val inten =  Intent(context, WebViewActivity::class.java)
                inten.putExtra("url", title)
                startActivity(inten)
            }


        })

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SportsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}