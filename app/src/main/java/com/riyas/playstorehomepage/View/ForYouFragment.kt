package com.riyas.playstorehomepage.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.riyas.playstorehomepage.Model.ApiService
import com.riyas.playstorehomepage.Model.RowModel
import com.riyas.playstorehomepage.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.util.*


class ForYouFragment:Fragment() {

    lateinit var network:ApiService
    lateinit var bannerViewPager:ViewPager
    lateinit var viewPagerAdapter:BannerImagePaggerAdapter

    lateinit var rowOneRecyclerView:RecyclerView
    lateinit var rowOneRecyclerAdapter:RowOneRecyclerViewAdapter

    lateinit var rowTwoRecyclerView:RecyclerView
    lateinit var rowTwoRecyclerAdapter:RowTwoRecyclerViewAdapter

    lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.for_you_fragment, null) as ViewGroup
        network = ApiService()
        bannerViewPager = root.findViewById(R.id.bannerViewPager)
        rowOneRecyclerView = root.findViewById(R.id.row1_recyclerView)
        rowTwoRecyclerView = root.findViewById(R.id.row2_recyclerView)
        progressBar = root.findViewById(R.id.progressBar)
        rowOneRecyclerView.setLayoutManager(
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        rowTwoRecyclerView.setLayoutManager(
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        showRowOneData()
        showBannerData()
        showRowTwoData()
        return root
    }
    private fun showRowOneData(){
        try {
            progressBar.visibility = View.VISIBLE
            lifecycleScope.launch(Dispatchers.IO) {
                val response: Response<List<RowModel>> = network.getRowData(10, 0)
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        rowOneRecyclerAdapter = RowOneRecyclerViewAdapter(requireContext(), response.body()!!)
                        rowOneRecyclerView.adapter = rowOneRecyclerAdapter
                    }
                }
                else{

                }
            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }
    private fun showRowTwoData(){
        try {
            lifecycleScope.launch(Dispatchers.IO) {
                val response: Response<List<RowModel>> = network.getRowData(10, 20)
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        rowTwoRecyclerAdapter = RowTwoRecyclerViewAdapter(requireContext(), response.body()!!)
                        rowTwoRecyclerView.adapter = rowTwoRecyclerAdapter
                        progressBar.visibility = View.GONE
                    }
                }
                else{

                }
            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }
    private fun showBannerData(){
        lifecycleScope.launch(Dispatchers.IO) {
            try{
                val response:Response<List<RowModel>> = network.getRowData(10, 10)
                if(response.isSuccessful){
                    withContext(Dispatchers.Main){
                        viewPagerAdapter = BannerImagePaggerAdapter(
                            requireContext(),
                            response.body()!!
                        )
                        bannerViewPager.adapter = viewPagerAdapter
                    }
                }
                else{

                }
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
}