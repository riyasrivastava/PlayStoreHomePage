package com.riyas.playstorehomepage.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.riyas.playstorehomepage.R

class GamesFragment : Fragment(){

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.games_fragment, null) as ViewGroup
        viewPager = root.findViewById<View>(R.id.viewPager) as ViewPager
        setupViewPager(viewPager)

        tabLayout = root.findViewById<View>(R.id.tabs) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.tabMode= TabLayout.MODE_SCROLLABLE
        return root
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(fragmentManager)
        adapter.addFragment(ForYouFragment(), "For you")
        adapter.addFragment(TopChartsFragment(), "Top charts")
        adapter.addFragment(KidsFragment(), "Kids")
        adapter.addFragment(EventsFragment(), "Events")
        adapter.addFragment(PremiumFragment(), "Premium")
        adapter.addFragment(CategoriesFragment(), "Categories")
        viewPager.adapter = adapter
    }
}