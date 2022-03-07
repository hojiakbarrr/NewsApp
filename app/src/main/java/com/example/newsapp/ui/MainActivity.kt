package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.R
import com.example.newsapp.bizness_ui.BiznesFragment
import com.example.newsapp.find.PoiskFragment
import com.example.newsapp.fragments_adapter.ViewPagerAdapter
import com.example.newsapp.health.HealthFragment
import com.example.newsapp.main_ui.News_Fragment
import com.example.newsapp.robotic.RobotFragment
import com.example.newsapp.sience.NaukaFragment
import com.example.newsapp.spor.SportsFragment
import com.example.newsapp.video.EntertainmentFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setUpTabs()

    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(News_Fragment(),"Main")
        adapter.addFragment(PoiskFragment(),"Search")
        adapter.addFragment(BiznesFragment(),"Business")
        adapter.addFragment(HealthFragment(),"Health")
        adapter.addFragment(RobotFragment(),"Robotic")
        adapter.addFragment(NaukaFragment(),"Science")
        adapter.addFragment(SportsFragment(),"Sport")
        adapter.addFragment(EntertainmentFragment(),"Entertainment")
        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)!!.setIcon(R.drawable.news)
        tabs.getTabAt(1)!!.setIcon(R.drawable.search)
        tabs.getTabAt(2)!!.setIcon(R.drawable.biznes)
        tabs.getTabAt(3)!!.setIcon(R.drawable.health)
        tabs.getTabAt(4)!!.setIcon(R.drawable.robot)
        tabs.getTabAt(5)!!.setIcon(R.drawable.science)
        tabs.getTabAt(6)!!.setIcon(R.drawable.sports)
        tabs.getTabAt(7)!!.setIcon(R.drawable.video)

    }
}